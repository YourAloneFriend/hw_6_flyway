ALTER TABLE project DROP FOREIGN KEY `project_ibfk_1`;
ALTER TABLE project ADD CONSTRAINT project_on_client_delete FOREIGN KEY(client_id) REFERENCES client(id) ON DELETE CASCADE;

ALTER TABLE project_worker DROP FOREIGN KEY `project_worker_ibfk_1`;
ALTER TABLE project_worker ADD CONSTRAINT project_worker_on_client_delete FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE;