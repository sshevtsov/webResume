CREATE TABLE resume (
  uuid      CHAR(36) PRIMARY KEY,
  full_name TEXT NOT NULL,
  about     TEXT
);

CREATE TABLE contact (
  id          SERIAL PRIMARY KEY,
  resume_uuid CHAR(36) NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
  type        TEXT     NOT NULL,
  value       TEXT     NOT NULL
);
CREATE UNIQUE INDEX contact_idx ON contact (resume_uuid, type);
