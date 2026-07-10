// System State
const state = {
  customers: [],
  agents: [],
  packages: [],
  historyLogs: [], // Log of package transitions: { id, packageId, status, timestamp, location, notes }
  activityLogs: []  // System log shown on Dashboard: { timestamp, packageId, event, details }
};

// Counters for Unique IDs
let customerCounter = 1001;
let agentCounter = 2001;
let packageCounter = 3001;
let logCounter = 5001;

// Lifecycle transition validation rules
const lifecycleTransitions = {
  'Created': ['Picked Up', 'Delayed', 'Lost'],
  'Picked Up': ['In Transit', 'Delayed', 'Lost', 'Returned'],
  'In Transit': ['Out for Delivery', 'Delayed', 'Lost', 'Returned'],
  'Out for Delivery': ['Delivered', 'Delayed', 'Lost', 'Returned'],
  'Delayed': ['Picked Up', 'In Transit', 'Out for Delivery', 'Delivered', 'Lost', 'Returned'],
  'Delivered': [], // Terminal
  'Lost': [],      // Terminal
  'Returned': []   // Terminal
};

// Initialize Application
window.addEventListener('DOMContentLoaded', () => {
  // Set system local time in footer & top-bar
  updateSystemTime();
  setInterval(updateSystemTime, 30000);
  
  // Seed initial mock data so dashboard is populated
  seedMockData(true); // silent seed on startup
  
  // Render dropdowns and listings
  refreshAllViews();
});

// Update display clock
function updateSystemTime() {
  const now = new Date();
  const formatStr = now.toISOString().replace('T', ' ').substring(0, 16);
  const sidebarTime = document.getElementById('sidebar-time-txt');
  const topBarTime = document.getElementById('top-bar-time');
  if (sidebarTime) sidebarTime.textContent = formatStr;
  if (topBarTime) topBarTime.textContent = `Logistics Admin Portal | ${formatStr}`;
}

// Switch Sidebar Tabs
function switchTab(tabId) {
  // Hide all sections
  document.querySelectorAll('.content-pane').forEach(pane => {
    pane.classList.remove('active');
  });
  // Deactivate all nav items
  document.querySelectorAll('.nav-item').forEach(item => {
    item.classList.remove('active');
  });
  
  // Activate selected
  const activePane = document.getElementById(`pane-${tabId}`);
  const activeNav = document.getElementById(`nav-${tabId}`);
  if (activePane) activePane.classList.add('active');
  if (activeNav) activeNav.classList.add('active');
  
  // Update header title
  const titleMap = {
    'dashboard': 'System Overview',
    'customers': 'Customer Management',
    'agents': 'Delivery Fleet Operations',
    'packages': 'Shipment Registry & Dispatch',
    'tracking': 'Package History Audit Trace',
    'reports': 'SQL Simulation & Analytics Reports'
  };
  document.getElementById('current-pane-title').textContent = titleMap[tabId] || 'Package System';

  // Specific tab entry hooks
  if (tabId === 'reports') {
    runSqlSimulator();
  }
}

// ----------------------------------------------------
// UI NOTIFICATION SYSTEM
// ----------------------------------------------------
function showNotification(message, type = 'success') {
  const container = document.getElementById('notification-area');
  const notification = document.createElement('div');
  notification.className = `notification ${type}`;
  
  let iconSVG = '';
  if (type === 'success') {
    iconSVG = `<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><polyline points="20 6 9 17 4 12"></polyline></svg>`;
  } else if (type === 'error') {
    iconSVG = `<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="12"></line><line x1="12" y1="16" x2="12.01" y2="16"></line></svg>`;
  } else {
    iconSVG = `<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="12"></line><line x1="12" y1="16" x2="12.01" y2="16"></line></svg>`;
  }
  
  notification.innerHTML = `
    ${iconSVG}
    <div>${message}</div>
  `;
  container.appendChild(notification);
  
  setTimeout(() => {
    notification.style.opacity = '0';
    notification.style.transform = 'translateY(10px)';
    setTimeout(() => {
      notification.remove();
    }, 200);
  }, 4000);
}

// ----------------------------------------------------
// MOCK DATA SEEDER
// ----------------------------------------------------
function seedMockData(silent = false) {
  // Clear collections if we are doing a manual seed override
  if (!silent) {
    state.customers = [];
    state.agents = [];
    state.packages = [];
    state.historyLogs = [];
    state.activityLogs = [];
    customerCounter = 1001;
    agentCounter = 2001;
    packageCounter = 3001;
    logCounter = 5001;
  }

  // Seed Customers
  const mockCustomers = [
    { name: 'Apex Tech Corp', address: '900 Broadway Ave, North Region', contact: '+1 (555) 014-9923' },
    { name: 'Elena Rostova', address: '45 Blue Lagoon Dr, South Region', contact: '+1 (555) 018-4729' },
    { name: 'Marcus Miller', address: '782 Peachtree St, East Region', contact: '+1 (555) 011-8841' },
    { name: 'Stellar Logistics Co', address: '302 Sunset Blvd, West Region', contact: '+1 (555) 019-3351' }
  ];
  mockCustomers.forEach(c => registerCustomer(c.name, c.address, c.contact));

  // Seed Agents
  const mockAgents = [
    { name: 'James Carter', region: 'North' },
    { name: 'Maya Patel', region: 'South' },
    { name: 'David Kim', region: 'East' },
    { name: 'Sarah Jenkins', region: 'West' },
    { name: 'Jordan Hayes', region: 'Central' },
    { name: 'Robert Vance', region: 'North' } // North has two agents to simulate SQL sorting
  ];
  mockAgents.forEach(a => registerAgent(a.name, a.region));

  // Seed Packages
  const mockPackages = [
    { customerId: 'CUST-1001', weight: 4.5, source: 'Chicago Distribution Center', destination: 'Apex Labs, Detroit', region: 'North', status: 'Created' },
    { customerId: 'CUST-1002', weight: 1.2, source: 'Atlanta Warehouse', destination: 'Suite 400, Miami Beach', region: 'South', status: 'Delivered', agentId: 'AGE-2002', pickupDate: '2026-07-04T09:00', deliveryDate: '2026-07-05T14:30' },
    { customerId: 'CUST-1003', weight: 18.0, source: 'Boston Logistics Hub', destination: '782 Peachtree St, Savannah', region: 'East', status: 'In Transit', agentId: 'AGE-2003', pickupDate: '2026-07-05T08:00' },
    { customerId: 'CUST-1004', weight: 0.8, source: 'Phoenix Terminal', destination: 'Intel Facility, Hillsboro', region: 'West', status: 'Delayed', agentId: 'AGE-2004', pickupDate: '2026-07-04T10:15' },
    { customerId: 'CUST-1001', weight: 6.2, source: 'Chicago Distribution Center', destination: 'Retail Outlet, Columbus', region: 'North', status: 'Delivered', agentId: 'AGE-2001', pickupDate: '2026-07-04T08:30', deliveryDate: '2026-07-05T11:15' },
    { customerId: 'CUST-1001', weight: 2.1, source: 'Chicago Distribution Center', destination: 'HQ Branch, Minneapolis', region: 'North', status: 'Delivered', agentId: 'AGE-2001', pickupDate: '2026-07-03T10:00', deliveryDate: '2026-07-04T12:00' }
  ];

  mockPackages.forEach(p => {
    const pkgId = `PKG-${packageCounter++}`;
    const newPkg = {
      id: pkgId,
      customerId: p.customerId,
      weight: parseFloat(p.weight),
      source: p.source,
      destination: p.destination,
      region: p.region,
      status: p.status,
      agentId: p.agentId || null,
      pickupDate: p.pickupDate || null,
      deliveryDate: p.deliveryDate || null,
      createdAt: new Date().toISOString()
    };
    state.packages.push(newPkg);
    
    // Seed transition history for mock packages
    if (p.status === 'Created') {
      addHistoryLog(pkgId, 'Created', 'Logistics Center', 'Package registered in in-memory system.', null);
    } else if (p.status === 'In Transit') {
      addHistoryLog(pkgId, 'Created', 'Boston Logistics Hub', 'Package registered', null);
      addHistoryLog(pkgId, 'Picked Up', 'Boston Logistics Hub', 'Picked up by courier', p.pickupDate);
      addHistoryLog(pkgId, 'In Transit', 'New York Sorting Facility', 'Departed sorting facility', addHoursToISOString(p.pickupDate, 4));
    } else if (p.status === 'Delayed') {
      addHistoryLog(pkgId, 'Created', 'Phoenix Terminal', 'Package registered', null);
      addHistoryLog(pkgId, 'Picked Up', 'Phoenix Terminal', 'Picked up by agent', p.pickupDate);
      addHistoryLog(pkgId, 'Delayed', 'LA Hub (Congestion)', 'Traffic holding in yard', addHoursToISOString(p.pickupDate, 6));
    } else if (p.status === 'Delivered') {
      addHistoryLog(pkgId, 'Created', p.source, 'Package registered', null);
      addHistoryLog(pkgId, 'Picked Up', p.source, 'Picked up by agent', p.pickupDate);
      addHistoryLog(pkgId, 'In Transit', 'Transit Hub', 'Sorted and shipped', addHoursToISOString(p.pickupDate, 12));
      addHistoryLog(pkgId, 'Out for Delivery', p.destination, 'Out with courier', addHoursToISOString(p.pickupDate, 20));
      addHistoryLog(pkgId, 'Delivered', p.destination, 'Signed off by front desk', p.deliveryDate);
    }
  });

  // Add operational log activity
  addActivityLog(null, 'SYSTEM', 'Mock database seeded with initial customers, agents, and packages.');
  
  if (!silent) {
    showNotification('System re-seeded with fresh test data!');
    refreshAllViews();
  }
}

// Helper: add hours to ISO date string for log sequencing
function addHoursToISOString(isoString, hours) {
  if (!isoString) return null;
  const d = new Date(isoString);
  d.setHours(d.getHours() + hours);
  return d.toISOString().substring(0, 16);
}

// ----------------------------------------------------
// LOGGING UTIL
// ----------------------------------------------------
function addHistoryLog(packageId, status, location, notes, timestamp = null) {
  const finalTime = timestamp || new Date().toISOString().substring(0, 16).replace('T', ' ');
  state.historyLogs.push({
    id: `LOG-${logCounter++}`,
    packageId,
    status,
    timestamp: finalTime,
    location,
    notes
  });
}

function addActivityLog(packageId, event, details) {
  const timestamp = new Date().toISOString().replace('T', ' ').substring(0, 19);
  state.activityLogs.unshift({
    timestamp,
    packageId: packageId || 'N/A',
    event,
    details
  });
  // Cap logs at 50 entries
  if (state.activityLogs.length > 50) {
    state.activityLogs.pop();
  }
}

// ----------------------------------------------------
// CUSTOMER REGISTRATION
// ----------------------------------------------------
function registerCustomer(name, address, contact) {
  const id = `CUST-${customerCounter++}`;
  state.customers.push({ id, name, address, contact, createdAt: new Date().toISOString() });
  addActivityLog(null, 'CUSTOMER_REG', `Registered customer ${name} (${id})`);
  return id;
}

function handleCustomerRegistration(event) {
  event.preventDefault();
  const nameInput = document.getElementById('cust-name');
  const addressInput = document.getElementById('cust-address');
  const contactInput = document.getElementById('cust-contact');
  
  const id = registerCustomer(nameInput.value.trim(), addressInput.value.trim(), contactInput.value.trim());
  showNotification(`Customer ${nameInput.value.trim()} registered as ${id}`);
  
  nameInput.value = '';
  addressInput.value = '';
  contactInput.value = '';
  
  refreshAllViews();
}

// ----------------------------------------------------
// AGENT REGISTRATION
// ----------------------------------------------------
function registerAgent(name, region) {
  const id = `AGE-${agentCounter++}`;
  state.agents.push({ id, name, region, activeWorkload: 0, totalDelivered: 0 });
  addActivityLog(null, 'AGENT_REG', `Registered agent ${name} for region ${region} (${id})`);
  return id;
}

function handleAgentRegistration(event) {
  event.preventDefault();
  const nameInput = document.getElementById('agent-name');
  const regionSelect = document.getElementById('agent-region');
  
  const id = registerAgent(nameInput.value.trim(), regionSelect.value);
  showNotification(`Agent ${nameInput.value.trim()} registered as ${id}`);
  
  nameInput.value = '';
  regionSelect.value = '';
  
  refreshAllViews();
}

// ----------------------------------------------------
// PACKAGE CREATION
// ----------------------------------------------------
function handlePackageCreation(event) {
  event.preventDefault();
  const customerSelect = document.getElementById('pkg-customer');
  const weightInput = document.getElementById('pkg-weight');
  const sourceInput = document.getElementById('pkg-source');
  const destInput = document.getElementById('pkg-destination');
  const regionSelect = document.getElementById('pkg-region');
  
  const weight = parseFloat(weightInput.value);
  const source = sourceInput.value.trim();
  const dest = destInput.value.trim();
  const region = regionSelect.value;
  const custId = customerSelect.value;

  // Validation rules
  if (weight <= 0) {
    showNotification('Package weight must be greater than zero kg!', 'error');
    return;
  }
  if (!source || !dest) {
    showNotification('Source and Destination addresses are required!', 'error');
    return;
  }
  if (!custId) {
    showNotification('A registered customer must be linked to this package!', 'error');
    return;
  }

  const pkgId = `PKG-${packageCounter++}`;
  const newPkg = {
    id: pkgId,
    customerId: custId,
    weight,
    source,
    destination: dest,
    region,
    status: 'Created',
    agentId: null,
    pickupDate: null,
    deliveryDate: null,
    createdAt: new Date().toISOString()
  };

  state.packages.push(newPkg);
  addHistoryLog(pkgId, 'Created', source, 'Shipment registered in warehouse queue.');
  addActivityLog(pkgId, 'PACKAGE_CREATE', `Created package for customer ${custId}. Destined for ${region} Region.`);
  
  showNotification(`Package registered successfully. Tracking ID: ${pkgId}`);
  
  weightInput.value = '';
  sourceInput.value = '';
  destInput.value = '';
  regionSelect.value = '';
  customerSelect.value = '';
  
  refreshAllViews();
}

// ----------------------------------------------------
// AGENT ASSIGNMENT
// ----------------------------------------------------
function openAssignAgentModal(pkgId) {
  const pkg = state.packages.find(p => p.id === pkgId);
  if (!pkg) return;
  
  if (pkg.status === 'Delivered' || pkg.status === 'Lost' || pkg.status === 'Returned') {
    showNotification('Cannot assign agents to terminal shipments!', 'error');
    return;
  }

  document.getElementById('agent-modal-pkg-id').value = pkgId;
  document.getElementById('agent-modal-lbl-id').textContent = pkgId;
  document.getElementById('agent-modal-lbl-dest').textContent = pkg.destination;
  document.getElementById('agent-modal-lbl-region').textContent = pkg.region;
  
  // Filter agents by region
  const eligibleAgents = state.agents.filter(a => a.region === pkg.region);
  const select = document.getElementById('agent-modal-select');
  select.innerHTML = '<option value="" disabled selected>Select Qualified Agent...</option>';
  
  if (eligibleAgents.length === 0) {
    select.innerHTML = `<option value="" disabled>No agents registered in region: ${pkg.region}</option>`;
  } else {
    eligibleAgents.forEach(agent => {
      // Calculate active workload (count of active packages assigned to agent)
      const workload = state.packages.filter(p => p.agentId === agent.id && p.status !== 'Delivered' && p.status !== 'Lost' && p.status !== 'Returned').length;
      select.innerHTML += `
        <option value="${agent.id}">${agent.name} (Active Workload: ${workload} pkgs)</option>
      `;
    });
  }

  document.getElementById('modal-agent-overlay').classList.add('active');
}

function handleAgentAssignment(event) {
  event.preventDefault();
  const pkgId = document.getElementById('agent-modal-pkg-id').value;
  const agentId = document.getElementById('agent-modal-select').value;
  
  const pkg = state.packages.find(p => p.id === pkgId);
  const agent = state.agents.find(a => a.id === agentId);
  
  if (!pkg || !agent) {
    showNotification('System mapping error. Package or Agent not found!', 'error');
    return;
  }

  // Double check region constraint
  if (agent.region !== pkg.region) {
    showNotification(`Region mismatch constraint! Agent region (${agent.region}) != Package destination region (${pkg.region})`, 'error');
    return;
  }

  // Swap agent tracking
  const previousAgentId = pkg.agentId;
  pkg.agentId = agent.id;
  
  // Log assignment
  addHistoryLog(pkgId, pkg.status, pkg.source, `Assigned to delivery agent ${agent.name} (ID: ${agent.id})`);
  addActivityLog(pkgId, 'AGENT_ASSIGN', `Dispatched package to agent ${agent.name} for ${pkg.region} region delivery.`);
  
  closeModal('agent');
  showNotification(`Package ${pkgId} successfully assigned to ${agent.name}.`);
  
  refreshAllViews();
}

// ----------------------------------------------------
// STATUS LIFECYCLE TRANSITIONS
// ----------------------------------------------------
function openUpdateStatusModal(pkgId) {
  const pkg = state.packages.find(p => p.id === pkgId);
  if (!pkg) return;
  
  // Locked terminal edits check
  if (pkg.status === 'Delivered') {
    showNotification('Delivered packages are locked from status edits.', 'error');
    return;
  }
  if (pkg.status === 'Lost' || pkg.status === 'Returned') {
    showNotification('Lost or Returned terminal packages cannot be edited.', 'error');
    return;
  }

  document.getElementById('status-modal-pkg-id').value = pkgId;
  document.getElementById('status-modal-lbl-id').textContent = pkgId;
  
  const currentLbl = document.getElementById('status-modal-lbl-current');
  currentLbl.className = `badge badge-${pkg.status.toLowerCase().replace(' ', '')}`;
  currentLbl.textContent = pkg.status;
  
  const select = document.getElementById('status-modal-select');
  select.innerHTML = '<option value="" disabled selected>Choose transition stage...</option>';
  
  // Load valid next transitions
  const transitions = lifecycleTransitions[pkg.status] || [];
  transitions.forEach(stateVal => {
    select.innerHTML += `<option value="${stateVal}">${stateVal}</option>`;
  });

  // Pre-fill location
  document.getElementById('status-modal-location').value = pkg.destination;
  document.getElementById('status-modal-notes').value = '';
  document.getElementById('status-modal-date-override').value = '';
  
  toggleSimulatedDates();
  document.getElementById('modal-status-overlay').classList.add('active');
}

// Toggle Simulated Date visibility when Delivered or Picked Up is selected
function toggleSimulatedDates() {
  const newStatus = document.getElementById('status-modal-select').value;
  const dateGroup = document.getElementById('date-override-group');
  if (newStatus === 'Delivered' || newStatus === 'Picked Up') {
    dateGroup.style.display = 'block';
  } else {
    dateGroup.style.display = 'none';
  }
}

function handleStatusUpdate(event) {
  event.preventDefault();
  const pkgId = document.getElementById('status-modal-pkg-id').value;
  const newStatus = document.getElementById('status-modal-select').value;
  const location = document.getElementById('status-modal-location').value.trim();
  const notes = document.getElementById('status-modal-notes').value.trim();
  const dateOverride = document.getElementById('status-modal-date-override').value;
  
  const pkg = state.packages.find(p => p.id === pkgId);
  if (!pkg) return;

  // Validate transition path again
  const allowed = lifecycleTransitions[pkg.status] || [];
  if (!allowed.includes(newStatus)) {
    showNotification(`Invalid transition path! Cannot move package from ${pkg.status} to ${newStatus}.`, 'error');
    return;
  }

  // Determine timestamp
  const logTimestamp = dateOverride ? dateOverride.replace('T', ' ') : null;

  // Constraint: Delivery date may not precede pickup date
  if (newStatus === 'Delivered') {
    const pickupDateVal = pkg.pickupDate;
    const deliveryDateVal = logTimestamp || new Date().toISOString().substring(0, 16).replace('T', ' ');
    
    if (pickupDateVal) {
      const pickupTime = new Date(pickupDateVal.replace(' ', 'T')).getTime();
      const deliveryTime = new Date(deliveryDateVal.replace(' ', 'T')).getTime();
      
      if (deliveryTime < pickupTime) {
        showNotification(`Validation Error: Delivery date (${deliveryDateVal}) may not precede pickup date (${pickupDateVal})!`, 'error');
        return;
      }
    }
    pkg.deliveryDate = deliveryDateVal;
  }
  
  if (newStatus === 'Picked Up') {
    const pickupDateVal = logTimestamp || new Date().toISOString().substring(0, 16).replace('T', ' ');
    pkg.pickupDate = pickupDateVal;
  }

  // Apply status transition
  pkg.status = newStatus;
  addHistoryLog(pkgId, newStatus, location, notes, logTimestamp);
  addActivityLog(pkgId, 'STATUS_UPDATE', `Transitioned to [${newStatus}] at location: ${location}. Note: ${notes}`);

  closeModal('status');
  showNotification(`Package ${pkgId} transitioned to ${newStatus}`);
  
  refreshAllViews();
}

// ----------------------------------------------------
// CLOSE MODALS
// ----------------------------------------------------
function closeModal(type) {
  document.getElementById(`modal-${type}-overlay`).classList.remove('active');
}

// ----------------------------------------------------
// VIEW RENDERING
// ----------------------------------------------------
function refreshAllViews() {
  renderCustomerSelects();
  renderCustomerList();
  renderAgentList();
  renderPackageList();
  updateDashboardMetrics();
  updateDetailedTrackOptions();
  renderRecentActivity();
  
  // If we are currently looking at a package detail, refresh it
  const currentDetailPkgId = document.getElementById('detailed-track-id').value;
  if (currentDetailPkgId) {
    handleDetailedTrackSelect(currentDetailPkgId);
  }
}

// Update dashboard high-level metric counts
function updateDashboardMetrics() {
  const total = state.packages.length;
  const active = state.packages.filter(p => p.status !== 'Delivered' && p.status !== 'Lost' && p.status !== 'Returned').length;
  const delivered = state.packages.filter(p => p.status === 'Delivered').length;
  const delayed = state.packages.filter(p => p.status === 'Delayed').length;
  
  document.getElementById('metric-total-packages').textContent = total;
  document.getElementById('metric-active-packages').textContent = active;
  document.getElementById('metric-delivered-packages').textContent = delivered;
  document.getElementById('metric-delayed-packages').textContent = delayed;

  // Stats Details
  document.getElementById('stat-cust-count').textContent = state.customers.length;
  document.getElementById('stat-agent-count').textContent = state.agents.length;
  
  const avgWeight = total > 0 ? (state.packages.reduce((sum, p) => sum + p.weight, 0) / total).toFixed(2) : '0.00';
  document.getElementById('stat-avg-weight').textContent = `${avgWeight} kg`;
}

// Populate customer select field in package creation form
function renderCustomerSelects() {
  const select = document.getElementById('pkg-customer');
  select.innerHTML = '<option value="" disabled selected>Select a Customer...</option>';
  state.customers.forEach(c => {
    select.innerHTML += `<option value="${c.id}">${c.name} (${c.id})</option>`;
  });
}

// Render customers view list
function renderCustomerList() {
  const searchVal = document.getElementById('search-customer').value.toLowerCase().trim();
  const tbody = document.getElementById('customer-table-body');
  tbody.innerHTML = '';
  
  const filtered = state.customers.filter(c => {
    return c.id.toLowerCase().includes(searchVal) ||
           c.name.toLowerCase().includes(searchVal) ||
           c.contact.toLowerCase().includes(searchVal) ||
           c.address.toLowerCase().includes(searchVal);
  });
  
  if (filtered.length === 0) {
    tbody.innerHTML = `<tr><td colspan="5" style="text-align: center; color: var(--text-muted);">No matching customers found.</td></tr>`;
    return;
  }
  
  filtered.forEach(c => {
    // Count packages linked to customer
    const count = state.packages.filter(p => p.customerId === c.id).length;
    tbody.innerHTML += `
      <tr>
        <td><strong>${c.id}</strong></td>
        <td>${c.name}</td>
        <td>${c.contact}</td>
        <td>${c.address}</td>
        <td style="text-align: right; font-weight: 600; color: var(--primary);">${count} packages</td>
      </tr>
    `;
  });
}

// Render delivery agents view list & workload progress
function renderAgentList() {
  const searchVal = document.getElementById('search-agent').value.toLowerCase().trim();
  const tbody = document.getElementById('agent-table-body');
  tbody.innerHTML = '';
  
  const filtered = state.agents.filter(a => {
    return a.id.toLowerCase().includes(searchVal) ||
           a.name.toLowerCase().includes(searchVal) ||
           a.region.toLowerCase().includes(searchVal);
  });

  if (filtered.length === 0) {
    tbody.innerHTML = `<tr><td colspan="6" style="text-align: center; color: var(--text-muted);">No matching delivery agents found.</td></tr>`;
    return;
  }

  filtered.forEach(a => {
    // Dynamically query workload (packages currently assigned and NOT delivered/lost/returned)
    const activeWorkload = state.packages.filter(p => p.agentId === a.id && p.status !== 'Delivered' && p.status !== 'Lost' && p.status !== 'Returned').length;
    const totalDelivered = state.packages.filter(p => p.agentId === a.id && p.status === 'Delivered').length;
    
    // Workload visual rating bar (up to 5 packages for maximum capacity before dispatch warning)
    const loadPercent = Math.min((activeWorkload / 5) * 100, 100);
    let barColor = 'var(--success)';
    if (activeWorkload >= 4) barColor = 'var(--error)';
    else if (activeWorkload >= 2) barColor = 'var(--warning)';

    tbody.innerHTML += `
      <tr>
        <td><strong>${a.id}</strong></td>
        <td>${a.name}</td>
        <td><span class="badge badge-pickup">${a.region}</span></td>
        <td><strong style="color: var(--text-primary);">${activeWorkload}</strong> active</td>
        <td>${totalDelivered} delivered</td>
        <td>
          <div style="display: flex; align-items: center; gap: 8px;">
            <div style="flex-grow: 1; height: 6px; background-color: var(--bg-primary); border-radius: 3px; overflow: hidden;">
              <div style="width: ${loadPercent}%; height: 100%; background-color: ${barColor}; transition: width 0.3s ease;"></div>
            </div>
            <span style="font-size: 0.75rem; color: var(--text-muted); min-width: 24px;">${activeWorkload}/5</span>
          </div>
        </td>
      </tr>
    `;
  });
}

// Render packages list
function renderPackageList() {
  const searchVal = document.getElementById('search-package').value.toLowerCase().trim();
  const filterStatus = document.getElementById('filter-status').value;
  const filterRegion = document.getElementById('filter-region').value;
  
  const tbody = document.getElementById('package-table-body');
  tbody.innerHTML = '';

  const filtered = state.packages.filter(p => {
    const cust = state.customers.find(c => c.id === p.customerId);
    const agent = state.agents.find(a => a.id === p.agentId);
    
    const matchesSearch = 
      p.id.toLowerCase().includes(searchVal) ||
      p.source.toLowerCase().includes(searchVal) ||
      p.destination.toLowerCase().includes(searchVal) ||
      (cust && cust.name.toLowerCase().includes(searchVal)) ||
      (agent && agent.name.toLowerCase().includes(searchVal));
      
    const matchesStatus = (filterStatus === 'ALL' || p.status === filterStatus);
    const matchesRegion = (filterRegion === 'ALL' || p.region === filterRegion);

    return matchesSearch && matchesStatus && matchesRegion;
  });

  document.getElementById('package-count-text').textContent = `Showing ${filtered.length} of ${state.packages.length} packages`;

  if (filtered.length === 0) {
    tbody.innerHTML = `<tr><td colspan="8" style="text-align: center; color: var(--text-muted); padding: 24px 0;">No matching shipments found.</td></tr>`;
    return;
  }

  filtered.forEach(p => {
    const customer = state.customers.find(c => c.id === p.customerId);
    const agent = state.agents.find(a => a.id === p.agentId);
    
    const statusClass = p.status.toLowerCase().replace(' ', '');
    const isTerminal = (p.status === 'Delivered' || p.status === 'Lost' || p.status === 'Returned');
    
    tbody.innerHTML += `
      <tr>
        <td>
          <a href="#" onclick="viewDirectTracking('${p.id}'); return false;" style="color: var(--primary); text-decoration: underline; font-weight: 600;">
            ${p.id}
          </a>
        </td>
        <td>
          <span style="font-weight: 500; color: var(--text-primary);">${customer ? customer.name : 'Unknown'}</span>
          <br><small style="color: var(--text-muted); font-size: 0.75rem;">${p.customerId}</small>
        </td>
        <td><span class="badge badge-pickup">${p.region}</span></td>
        <td>${p.weight.toFixed(1)} kg</td>
        <td><span style="font-size: 0.85rem;" title="${p.destination}">${p.destination}</span></td>
        <td><span class="badge badge-${statusClass}">${p.status}</span></td>
        <td>
          ${agent ? `<strong>${agent.name}</strong>` : `<em style="color: var(--text-muted);">Unassigned</em>`}
        </td>
        <td>
          <div style="display: flex; gap: 6px;">
            <button class="btn btn-secondary btn-sm" onclick="viewDirectTracking('${p.id}')">Details</button>
            <button class="btn btn-secondary btn-sm" onclick="openAssignAgentModal('${p.id}')" ${isTerminal ? 'disabled' : ''}>Assign</button>
            <button class="btn btn-primary btn-sm" onclick="openUpdateStatusModal('${p.id}')" ${isTerminal ? 'disabled' : ''}>Transition</button>
          </div>
        </td>
      </tr>
    `;
  });
}

// ----------------------------------------------------
// TRACKING AUDIT VIEW & SEARCH
// ----------------------------------------------------
function updateDetailedTrackOptions() {
  const select = document.getElementById('detailed-track-id');
  const currentVal = select.value;
  
  select.innerHTML = '<option value="" disabled selected>Choose package...</option>';
  state.packages.forEach(p => {
    select.innerHTML += `<option value="${p.id}">${p.id} (Dest: ${p.destination})</option>`;
  });

  if (currentVal && state.packages.some(p => p.id === currentVal)) {
    select.value = currentVal;
  }
}

function handleDetailedTrack(event) {
  event.preventDefault();
}

function handleDetailedTrackSelect(pkgId) {
  const pkg = state.packages.find(p => p.id === pkgId);
  const summaryContainer = document.getElementById('detailed-package-summary');
  const timelineContainer = document.getElementById('detailed-timeline-container');
  
  if (!pkg) {
    summaryContainer.style.display = 'none';
    timelineContainer.innerHTML = '<p style="text-align:center; color:var(--text-muted);">Package not found.</p>';
    return;
  }

  const customer = state.customers.find(c => c.id === pkg.customerId);
  const agent = state.agents.find(a => a.id === pkg.agentId);

  // Render Details Card
  summaryContainer.style.display = 'block';
  summaryContainer.innerHTML = `
    <h4 style="font-size: 0.95rem; font-weight: 600; margin-bottom: 12px; color: var(--text-primary);">Shipment Manifest</h4>
    <table style="width: 100%; font-size: 0.8rem; border-collapse: collapse; border: 1px solid var(--border-color);">
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600; width: 40%;">Sender Client</td>
        <td>${customer ? customer.name : 'Unknown'}</td>
      </tr>
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600;">Contact Phone</td>
        <td>${customer ? customer.contact : 'N/A'}</td>
      </tr>
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600;">Source Hub</td>
        <td>${pkg.source}</td>
      </tr>
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600;">Destination</td>
        <td>${pkg.destination}</td>
      </tr>
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600;">Weight</td>
        <td>${pkg.weight} kg</td>
      </tr>
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600;">Designated Region</td>
        <td><span class="badge badge-pickup">${pkg.region} Region</span></td>
      </tr>
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600;">Active Courier</td>
        <td>${agent ? `${agent.name} (${agent.id})` : '<span style="color:var(--text-muted);">None Assigned</span>'}</td>
      </tr>
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600;">Pickup Clock</td>
        <td>${pkg.pickupDate || '<span style="color:var(--text-muted);">Awaiting Pickup</span>'}</td>
      </tr>
      <tr>
        <td style="background-color: rgba(255, 255, 255, 0.02); font-weight: 600;">Delivery Clock</td>
        <td>${pkg.deliveryDate || '<span style="color:var(--text-muted);">In Transit</span>'}</td>
      </tr>
    </table>
  `;

  // Render timeline logs
  const logs = state.historyLogs.filter(l => l.packageId === pkgId);
  // Sort logs by time (chronological)
  logs.sort((a, b) => new Date(a.timestamp) - new Date(b.timestamp));

  if (logs.length === 0) {
    timelineContainer.innerHTML = '<p style="text-align: center; color: var(--text-muted); padding: 24px;">No timeline logs recorded.</p>';
    return;
  }

  let html = '<div class="timeline">';
  logs.forEach((log, index) => {
    const isLast = (index === logs.length - 1);
    const isEx = ['Delayed', 'Lost', 'Returned'].includes(log.status);
    const itemClass = isLast ? (isEx ? 'timeline-item active exception' : 'timeline-item active') : 'timeline-item completed';
    
    html += `
      <div class="${itemClass}">
        <div class="timeline-marker"></div>
        <div class="timeline-content">
          <div class="timeline-header">
            <span class="timeline-title">${log.status}</span>
            <span class="timeline-time">${log.timestamp}</span>
          </div>
          <div style="font-size: 0.8rem; color: var(--primary); font-weight: 500; margin-bottom: 4px;">📍 Location: ${log.location}</div>
          <div class="timeline-desc">${log.notes}</div>
        </div>
      </div>
    `;
  });
  html += '</div>';
  timelineContainer.innerHTML = html;
}

// Quick tracking from Dashboard Search
function handleQuickTrack(event) {
  event.preventDefault();
  const searchInput = document.getElementById('quick-track-id');
  const queryId = searchInput.value.toUpperCase().trim();
  
  const pkg = state.packages.find(p => p.id === queryId);
  const resultDiv = document.getElementById('quick-track-result');
  resultDiv.style.display = 'block';

  if (!pkg) {
    resultDiv.innerHTML = `
      <div style="background-color: var(--error-glow); border: 1px solid rgba(248, 113, 113, 0.2); padding: 12px; border-radius: var(--border-radius-sm); color: var(--error); font-size: 0.85rem;">
        No package matches tracking reference: <strong>${queryId}</strong>
      </div>
    `;
    return;
  }

  const statusClass = pkg.status.toLowerCase().replace(' ', '');
  const agent = state.agents.find(a => a.id === pkg.agentId);

  resultDiv.innerHTML = `
    <div style="background-color: var(--bg-primary); border: 1px solid var(--border-color); padding: 16px; border-radius: var(--border-radius-sm); font-size: 0.85rem;">
      <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px;">
        <span style="font-weight:600;">Status: <span class="badge badge-${statusClass}">${pkg.status}</span></span>
        <a href="#" onclick="viewDirectTracking('${pkg.id}'); return false;" style="color:var(--primary); font-weight:600; text-decoration:underline;">Inspect Full Log &rarr;</a>
      </div>
      <div style="color: var(--text-secondary); display:flex; flex-direction:column; gap:4px;">
        <div>Destination: <strong>${pkg.destination}</strong></div>
        <div>Weight: <strong>${pkg.weight} kg</strong></div>
        <div>Assignee Agent: <strong>${agent ? agent.name : 'None Assigned'}</strong></div>
      </div>
    </div>
  `;
}

// Redirect and view a package on the tracking logs page directly
function viewDirectTracking(pkgId) {
  document.getElementById('detailed-track-id').value = pkgId;
  switchTab('tracking');
  handleDetailedTrackSelect(pkgId);
}

// ----------------------------------------------------
// SQL SIMULATION ENGINE & OPERATIONAL REPORTS
// ----------------------------------------------------
function runSqlSimulator() {
  // Query requirement: List delivery agents with total number of packages delivered, sorted by highest deliveries
  // SQL Equivalent:
  // SELECT a.agent_id, a.name, a.region, COUNT(p.package_id) as total_delivered 
  // FROM agents a LEFT JOIN packages p ON a.agent_id = p.agent_id AND p.status = 'Delivered'
  // GROUP BY a.agent_id, a.name, a.region ORDER BY total_delivered DESC;

  const resultTableBody = document.getElementById('sql-result-body');
  resultTableBody.innerHTML = '';

  // Execute equivalent JS engine logic
  const sqlResultSet = state.agents.map(agent => {
    // Count matching delivered packages
    const deliveredCount = state.packages.filter(
      p => p.agentId === agent.id && p.status === 'Delivered'
    ).length;

    return {
      agentId: agent.id,
      name: agent.name,
      region: agent.region,
      total_delivered: deliveredCount
    };
  });

  // Sort descending by count
  sqlResultSet.sort((a, b) => b.total_delivered - a.total_delivered);

  // Render SQL Simulator Result set
  sqlResultSet.forEach(row => {
    resultTableBody.innerHTML += `
      <tr>
        <td><strong>${row.agentId}</strong></td>
        <td>${row.name}</td>
        <td><span class="badge badge-pickup">${row.region}</span></td>
        <td style="text-align: right; font-weight:700; color: var(--success);">${row.total_delivered} DELIVERIES</td>
      </tr>
    `;
  });

  // Also update Delayed Exceptions list
  renderDelayedReport();

  // Also update Region breakdown
  renderRegionBreakdown();
}

function renderDelayedReport() {
  const tbody = document.getElementById('delayed-report-body');
  tbody.innerHTML = '';
  
  const delayed = state.packages.filter(p => p.status === 'Delayed');
  
  if (delayed.length === 0) {
    tbody.innerHTML = `<tr><td colspan="4" style="text-align:center; color:var(--text-muted); font-size:0.8rem; padding: 12px 0;">No active shipment exceptions. Everything on track!</td></tr>`;
    return;
  }
  
  delayed.forEach(p => {
    const agent = state.agents.find(a => a.id === p.agentId);
    tbody.innerHTML += `
      <tr>
        <td>
          <a href="#" onclick="viewDirectTracking('${p.id}'); return false;" style="color:var(--primary); font-weight:600;">
            ${p.id}
          </a>
        </td>
        <td><div style="font-size:0.8rem; max-width:140px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;" title="${p.destination}">${p.destination}</div></td>
        <td>${agent ? agent.name : 'Unassigned'}</td>
        <td><span class="badge badge-delayed">${p.status}</span></td>
      </tr>
    `;
  });
}

function renderRegionBreakdown() {
  const container = document.getElementById('region-breakdown-container');
  container.innerHTML = '';

  const regionsList = ['North', 'South', 'East', 'West', 'Central'];
  
  regionsList.forEach(r => {
    const activeCount = state.packages.filter(p => p.region === r && p.status !== 'Delivered' && p.status !== 'Lost' && p.status !== 'Returned').length;
    const fleetCount = state.agents.filter(a => a.region === r).length;
    
    container.innerHTML += `
      <div style="background-color: var(--bg-primary); border: 1px solid var(--border-color); border-radius: var(--border-radius-sm); padding: 12px; display:flex; justify-content:space-between; align-items:center;">
        <div>
          <div style="font-size:0.85rem; font-weight:600; color:var(--text-primary);">${r} Region</div>
          <small style="color:var(--text-muted); font-size:0.75rem;">Active Fleet: ${fleetCount} agent(s)</small>
        </div>
        <div style="text-align:right;">
          <div style="font-size:1rem; font-weight:700; color: var(--accent);">${activeCount} active pkgs</div>
          <small style="color:var(--text-muted); font-size:0.7rem;">Region capacity</small>
        </div>
      </div>
    `;
  });
}

function renderRecentActivity() {
  const tbody = document.getElementById('activity-log-body');
  if (state.activityLogs.length === 0) {
    tbody.innerHTML = `<tr><td colspan="4" style="text-align:center; color:var(--text-muted);">No activity recorded.</td></tr>`;
    return;
  }
  
  tbody.innerHTML = '';
  state.activityLogs.forEach(log => {
    tbody.innerHTML += `
      <tr>
        <td style="font-size: 0.8rem; font-family: 'JetBrains Mono', monospace; width: 15%;">${log.timestamp.substring(11)}</td>
        <td style="width: 15%;">
          ${log.packageId !== 'N/A' ? `<a href="#" onclick="viewDirectTracking('${log.packageId}'); return false;" style="color:var(--primary); font-weight:600;">${log.packageId}</a>` : '<span style="color:var(--text-muted);">N/A</span>'}
        </td>
        <td style="font-weight: 600; font-size: 0.8rem; width: 20%; color: var(--text-primary);">${log.event}</td>
        <td style="font-size: 0.85rem; width: 50%;">${log.details}</td>
      </tr>
    `;
  });
}
