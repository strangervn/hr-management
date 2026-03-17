import React, { useContext } from 'react';
import { AuthContext } from '../context/AuthContext';
import { Users, Briefcase, CheckSquare, TrendingUp } from 'lucide-react';

const Dashboard: React.FC = () => {
  const authContext = useContext(AuthContext);

  return (
    <div className="page-container">
      <div className="page-header">
        <h1>Dashboard</h1>
        <p>Welcome back, {authContext?.user?.username}!</p>
      </div>

      <div className="stat-grid">
        <div className="stat-card">
          <div className="stat-icon users-icon"><Users /></div>
          <div className="stat-content">
            <h3>Total Employees</h3>
            <p className="stat-value">--</p>
          </div>
        </div>
        
        <div className="stat-card">
          <div className="stat-icon dept-icon"><Briefcase /></div>
          <div className="stat-content">
            <h3>Departments</h3>
            <p className="stat-value">--</p>
          </div>
        </div>
        
        <div className="stat-card">
          <div className="stat-icon tasks-icon"><CheckSquare /></div>
          <div className="stat-content">
            <h3>Active Tasks</h3>
            <p className="stat-value">--</p>
          </div>
        </div>
        
        <div className="stat-card">
          <div className="stat-icon perf-icon"><TrendingUp /></div>
          <div className="stat-content">
            <h3>Completion Rate</h3>
            <p className="stat-value">--%</p>
          </div>
        </div>
      </div>
      
      <div className="dashboard-content">
        <div className="dashboard-card recent-activity">
          <h2>Recent Activity</h2>
          <div className="empty-state">
            <p>No recent activity to show.</p>
          </div>
        </div>
        
        <div className="dashboard-card upcoming-tasks">
          <h2>Your Tasks</h2>
          <div className="empty-state">
            <p>You have no pending tasks right now.</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
