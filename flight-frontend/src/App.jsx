import React, { useState, useEffect } from 'react';
import { Search, Globe2, PlaneTakeoff } from 'lucide-react';
import { flightApi } from './services/api';
import FlightCard from './components/FlightCard';
import FlightForm from './components/FlightForm';
import './App.css';

function App() {
  const [flights, setFlights] = useState([]);
  const [loading, setLoading] = useState(true);
  const [searchQuery, setSearchQuery] = useState('');
  const [searchType, setSearchType] = useState('all');

  // Load all flights initially
  useEffect(() => {
    fetchFlights();
  }, []);

  const fetchFlights = async () => {
    try {
      setLoading(true);
      const data = await flightApi.getAll();
      setFlights(data);
    } catch (error) {
      console.error('Failed to fetch flights:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleAddFlight = async (flightData) => {
    try {
      const newFlight = await flightApi.add(flightData);
      setFlights([...flights, newFlight]);
    } catch (error) {
      console.error('Failed to add flight:', error);
      alert('Failed to add flight. Make sure the backend is running.');
    }
  };

  const handleDeleteFlight = async (id) => {
    try {
      await flightApi.delete(id);
      setFlights(flights.filter(f => f.code !== id));
    } catch (error) {
      console.error('Failed to delete flight:', error);
    }
  };

  const handleSearch = async (e) => {
    e.preventDefault();
    if (!searchQuery && searchType !== 'all') return;
    
    setLoading(true);
    try {
      if (searchType === 'all') {
        await fetchFlights();
      } else if (searchType === 'id') {
        const data = await flightApi.getById(searchQuery);
        setFlights(data ? [data] : []);
      } else if (searchType === 'carrier') {
        const data = await flightApi.getByCarrier(searchQuery);
        setFlights(data);
      }
    } catch (error) {
      console.error('Search failed:', error);
      setFlights([]);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container">
      <header className="app-header glass">
        <div className="brand">
          <Globe2 size={28} className="brand-icon" />
          <span>FlightService Explorer</span>
        </div>
        <div style={{ color: 'var(--text-muted)', display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
          <PlaneTakeoff size={18} />
          <span>Manage your global routes</span>
        </div>
      </header>

      <main className="main-grid">
        {/* Left Column: Form */}
        <aside>
          <FlightForm onAdd={handleAddFlight} />
        </aside>

        {/* Right Column: List & Search */}
        <section>
          <div className="search-bar glass" style={{ padding: '1rem', borderRadius: '1rem' }}>
            <form onSubmit={handleSearch} style={{ display: 'flex', width: '100%', gap: '1rem', flexWrap: 'wrap' }}>
              <div style={{ minWidth: '150px' }}>
                <select 
                  value={searchType} 
                  onChange={(e) => setSearchType(e.target.value)}
                  style={{ height: '100%' }}
                >
                  <option value="all">All Flights</option>
                  <option value="id">By Flight ID (Code)</option>
                  <option value="carrier">By Carrier</option>
                </select>
              </div>
              
              <div className="search-input-wrapper">
                <Search size={18} className="search-icon" />
                <input 
                  type="text" 
                  placeholder={searchType === 'all' ? "Click search to reload all..." : `Search by ${searchType}...`}
                  value={searchQuery}
                  onChange={(e) => setSearchQuery(e.target.value)}
                  disabled={searchType === 'all'}
                />
              </div>
              
              <button type="submit" className="btn btn-primary">
                Search
              </button>
            </form>
          </div>

          <div className="flights-container">
            {loading ? (
              <div className="empty-state">Loading flights...</div>
            ) : flights.length === 0 ? (
              <div className="empty-state">
                <PlaneTakeoff size={48} className="empty-icon" />
                <h3>No flights found</h3>
                <p>Try adjusting your search or add a new flight.</p>
              </div>
            ) : (
              <div className="flights-grid">
                {flights.map(flight => (
                  <FlightCard 
                    key={flight.code} 
                    flight={flight} 
                    onDelete={handleDeleteFlight} 
                  />
                ))}
              </div>
            )}
          </div>
        </section>
      </main>
    </div>
  );
}

export default App;
