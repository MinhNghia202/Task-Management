/*CREATE TABLE user (
    id VARCHAR(100) PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(20) DEFAULT 'User',
    status VARCHAR(20) DEFAULT 'Free',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE workspace (
    id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    owner_id VARCHAR(100),
    FOREIGN KEY (owner_id) REFERENCES User(id) ON DELETE SET NULL
);

CREATE TABLE task (
    id VARCHAR(100) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20) DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date TIMESTAMP,
    workspace_id VARCHAR(100),
    FOREIGN KEY (workspace_id) REFERENCES Workspace(id) ON DELETE CASCADE
);

CREATE TABLE user_workspace (
    user_id VARCHAR(100),
    workspace_id VARCHAR(100),
    role VARCHAR(20) DEFAULT 'Member',
    PRIMARY KEY (user_id, workspace_id),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (workspace_id) REFERENCES Workspace(id) ON DELETE CASCADE
);

CREATE TABLE user_task (
    user_id VARCHAR(100),
    task_id VARCHAR(100),
    PRIMARY KEY (user_id, task_id),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (task_id) REFERENCES Task(id) ON DELETE CASCADE
);

CREATE TABLE subscription (
    id VARCHAR(100) PRIMARY KEY,
    user_id VARCHAR(100) NOT NULL,
    plan VARCHAR(20),
    start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    end_date TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Active',
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

INSERT INTO user (id, username,password, email, role, status, created_at) VALUES 
('1', 'admin','123', 'admin@example.com', 'Admin', 'Paid', NOW()),
('2', 'user1','123', 'user1@example.com', 'User', 'Free', NOW()),
('3', 'user2','123', 'user2@example.com', 'User', 'Paid', NOW()),
('4', 'user3','123', 'user3@example.com', 'User', 'Paid', NOW());

INSERT INTO workspace (id, name, description, created_at, owner_id) VALUES 
('1', 'Development Team', 'Workspace for development projects', NOW(), '1'),
('2', 'Marketing Team', 'Workspace for marketing campaigns', NOW(), '2'),
('3', 'HR Team', 'Workspace for HR activities', NOW(), '3');

INSERT INTO task (id, title, description, status, created_at, due_date, workspace_id) VALUES 
('1', 'Design database schema', 'Create initial database schema for the project', 'Pending', NOW(), '2024-12-01', '1'),
('2', 'Develop API endpoints', 'Create REST API for project', 'In Progress', NOW(), '2024-12-15', '1'),
('3', 'Content Strategy', 'Develop content strategy for new product launch', 'Pending', NOW(), '2024-11-30', '2'),
('4', 'Recruitment Drive', 'Plan recruitment campaign for Q1', 'Pending', NOW(), '2025-01-10', '3');

INSERT INTO user_workspace (user_id, workspace_id, role) VALUES 
('1', '1', 'Admin'),
('2', '1', 'Member'),
('2', '2', 'Admin'),
('3', '2', 'Member'),
('4', '3', 'Admin'),
('3', '3', 'Member');

INSERT INTO user_task (user_id, task_id) VALUES 
('1', '1'),
('2', '2'),
('3', '3'),
('4', '4');

INSERT INTO subscription (id, user_id, plan, start_date, end_date, status) VALUES 
('1', '1', 'Yearly', NOW(), '2025-11-07', 'Active'),
('2', '2', 'Monthly', NOW(), '2024-12-07', 'Active'),
('3', '3', 'Yearly', NOW(), '2025-11-07', 'Active'),
('4', '4', 'Monthly', NOW(), '2024-12-07', 'Active');
*/
-- Kiểm tra tất cả người dùng
SELECT * FROM user;

-- Kiểm tra tất cả không gian làm việc
SELECT * FROM workspace;

-- Kiểm tra tất cả công việc
SELECT * FROM task;

-- Kiểm tra liên kết giữa người dùng và không gian làm việc
SELECT * FROM user_workspace;

-- Kiểm tra liên kết giữa người dùng và công việc
SELECT * FROM user_task;

-- Kiểm tra gói dịch vụ của người dùng
SELECT * FROM subscription;





