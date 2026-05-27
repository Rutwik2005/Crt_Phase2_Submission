import React from 'react';
import { Plane, MapPin, Trash2 } from 'lucide-react';

const FlightCard = ({ flight, onDelete }) => {
  return (
    <div className="flight-card glass animate-fade-in">
      <div className="card-header">
        <div className="carrier-name">
          <Plane size={18} className="brand-icon" />
          {flight.carrier}
        </div>
        <span className="flight-code">#{flight.code}</span>
      </div>
      
      <div className="route">
        <div className="route-point">
          <div className="route-city">{flight.source}</div>
          <div style={{ fontSize: '0.875rem', color: 'var(--text-muted)' }}>Origin</div>
        </div>
        
        <div className="route-divider">
          <span style={{ fontSize: '1.5rem', lineHeight: 1 }}>✈</span>
          <div style={{ borderTop: '1px dashed var(--border)', width: '100%', marginTop: '0.5rem' }}></div>
        </div>
        
        <div className="route-point">
          <div className="route-city">{flight.destination}</div>
          <div style={{ fontSize: '0.875rem', color: 'var(--text-muted)' }}>Destination</div>
        </div>
      </div>
      
      <div className="card-footer">
        <div className="price">${flight.cost.toFixed(2)}</div>
        <button 
          className="btn btn-danger" 
          onClick={() => onDelete(flight.code)}
          title="Delete Flight"
        >
          <Trash2 size={16} />
        </button>
      </div>
    </div>
  );
};

export default FlightCard;
