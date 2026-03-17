import React, { useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import { LogOut, Home, Users, Briefcase, CheckSquare, Menu } from 'lucide-react';

const Navbar: React.FC = () => {
  const authContext = useContext(AuthContext);
  const navigate = useNavigate();

  if (!authContext?.isAuthenticated || !authContext.user) {
    return null;
  }

  const handleLogout = () => {
    authContext.logout();
    navigate('/login');
  };

  return (
    <nav className="navbar">
      <div className="navbar-container">
        <div className="navbar-brand">
          <Briefcase className="brand-icon" />
          <Link to="/dashboard">HR Portal</Link>
        </div>
        
        <div className="navbar-menu">
          <Link to="/dashboard" className="nav-item">
            <Home size={18} />
            <span>Dashboard</span>
          </Link>
          <Link to="/departments" className="nav-item">
            <Briefcase size={18} />
            <span>Departments</span>
          </Link>
          <Link to="/employees" className="nav-item">
            <Users size={18} />
            <span>Employees</span>
          </Link>
          <Link to="/tasks" className="nav-item">
            <CheckSquare size={18} />
            <span>Tasks</span>
          </Link>
        </div>
        
        <div className="navbar-user">
          <div className="user-info">
            <span className="user-name">{authContext.user.username}</span>
            <span className="user-role">{authContext.user.role}</span>
          </div>
          <button onClick={handleLogout} className="logout-btn" title="Logout">
            <LogOut size={20} />
          </button>
        </div>
        
        <button className="mobile-menu-btn">
          <Menu size={24} />
        </button>
      </div>
    </nav>
  );
};

export default Navbar;
