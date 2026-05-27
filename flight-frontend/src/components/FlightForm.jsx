import React, { useState } from 'react';
import { PlusCircle } from 'lucide-react';

const FlightForm = ({ onAdd }) => {
  const [formData, setFormData] = useState({
    carrier: '',
    source: '',
    destination: '',
    cost: ''
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!formData.carrier || !formData.source || !formData.destination || !formData.cost) return;
    
    onAdd({
      ...formData,
      cost: parseFloat(formData.cost)
    });
    
    setFormData({ carrier: '', source: '', destination: '', cost: '' });
  };

  const handleChange = (e) => {
    setFormData(prev => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  return (
    <div className="form-card glass">
      <h2 className="form-title">
        <PlusCircle className="brand-icon" />
        Add New Flight
      </h2>
      
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="carrier">Carrier Name</label>
          <input 
            type="text" 
            id="carrier" 
            name="carrier" 
            value={formData.carrier}
            onChange={handleChange}
            placeholder="e.g. Delta Airlines"
            required
          />
        </div>
        
        <div className="form-group">
          <label htmlFor="source">Source City</label>
          <input 
            type="text" 
            id="source" 
            name="source" 
            value={formData.source}
            onChange={handleChange}
            placeholder="e.g. New York"
            required
          />
        </div>
        
        <div className="form-group">
          <label htmlFor="destination">Destination City</label>
          <input 
            type="text" 
            id="destination" 
            name="destination" 
            value={formData.destination}
            onChange={handleChange}
            placeholder="e.g. London"
            required
          />
        </div>
        
        <div className="form-group">
          <label htmlFor="cost">Ticket Cost ($)</label>
          <input 
            type="number" 
            id="cost" 
            name="cost" 
            value={formData.cost}
            onChange={handleChange}
            placeholder="e.g. 450.00"
            min="0"
            step="0.01"
            required
          />
        </div>
        
        <button type="submit" className="btn btn-primary" style={{ width: '100%', marginTop: '1rem' }}>
          Add Flight
        </button>
      </form>
    </div>
  );
};

export default FlightForm;
