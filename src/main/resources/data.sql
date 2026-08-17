-- ===== TEAMS =====
-- Group A
INSERT INTO teams (name, short_name, group_name) VALUES ('Mumbai Strikers', 'MUM', 'A');
INSERT INTO teams (name, short_name, group_name) VALUES ('Chennai Lions', 'CHE', 'A');
INSERT INTO teams (name, short_name, group_name) VALUES ('Delhi Warriors', 'DEL', 'A');

-- Group B
INSERT INTO teams (name, short_name, group_name) VALUES ('Punjab Kings', 'PUN', 'B');
INSERT INTO teams (name, short_name, group_name) VALUES ('Rajasthan Royals', 'RAJ', 'B');
INSERT INTO teams (name, short_name, group_name) VALUES ('Hyderabad Sultans', 'HYD', 'B');

-- ===== PLAYERS =====
-- Team 1: Mumbai Strikers
INSERT INTO players (name, jersey_number, team_id) VALUES ('MUM Player 1', 1, 1);
INSERT INTO players (name, jersey_number, team_id) VALUES ('MUM Player 2', 2, 1);
INSERT INTO players (name, jersey_number, team_id) VALUES ('MUM Player 3', 3, 1);
INSERT INTO players (name, jersey_number, team_id) VALUES ('MUM Player 4', 4, 1);
INSERT INTO players (name, jersey_number, team_id) VALUES ('MUM Player 5', 5, 1);
INSERT INTO players (name, jersey_number, team_id) VALUES ('MUM Player 6', 6, 1);
INSERT INTO players (name, jersey_number, team_id) VALUES ('MUM Player 7', 7, 1);

-- Team 2: Chennai Lions
INSERT INTO players (name, jersey_number, team_id) VALUES ('CHE Player 1', 1, 2);
INSERT INTO players (name, jersey_number, team_id) VALUES ('CHE Player 2', 2, 2);
INSERT INTO players (name, jersey_number, team_id) VALUES ('CHE Player 3', 3, 2);
INSERT INTO players (name, jersey_number, team_id) VALUES ('CHE Player 4', 4, 2);
INSERT INTO players (name, jersey_number, team_id) VALUES ('CHE Player 5', 5, 2);
INSERT INTO players (name, jersey_number, team_id) VALUES ('CHE Player 6', 6, 2);
INSERT INTO players (name, jersey_number, team_id) VALUES ('CHE Player 7', 7, 2);

-- Team 3: Delhi Warriors
INSERT INTO players (name, jersey_number, team_id) VALUES ('DEL Player 1', 1, 3);
INSERT INTO players (name, jersey_number, team_id) VALUES ('DEL Player 2', 2, 3);
INSERT INTO players (name, jersey_number, team_id) VALUES ('DEL Player 3', 3, 3);
INSERT INTO players (name, jersey_number, team_id) VALUES ('DEL Player 4', 4, 3);
INSERT INTO players (name, jersey_number, team_id) VALUES ('DEL Player 5', 5, 3);
INSERT INTO players (name, jersey_number, team_id) VALUES ('DEL Player 6', 6, 3);
INSERT INTO players (name, jersey_number, team_id) VALUES ('DEL Player 7', 7, 3);

-- Team 4: Punjab Kings
INSERT INTO players (name, jersey_number, team_id) VALUES ('PUN Player 1', 1, 4);
INSERT INTO players (name, jersey_number, team_id) VALUES ('PUN Player 2', 2, 4);
INSERT INTO players (name, jersey_number, team_id) VALUES ('PUN Player 3', 3, 4);
INSERT INTO players (name, jersey_number, team_id) VALUES ('PUN Player 4', 4, 4);
INSERT INTO players (name, jersey_number, team_id) VALUES ('PUN Player 5', 5, 4);
INSERT INTO players (name, jersey_number, team_id) VALUES ('PUN Player 6', 6, 4);
INSERT INTO players (name, jersey_number, team_id) VALUES ('PUN Player 7', 7, 4);

-- Team 5: Rajasthan Royals
INSERT INTO players (name, jersey_number, team_id) VALUES ('RAJ Player 1', 1, 5);
INSERT INTO players (name, jersey_number, team_id) VALUES ('RAJ Player 2', 2, 5);
INSERT INTO players (name, jersey_number, team_id) VALUES ('RAJ Player 3', 3, 5);
INSERT INTO players (name, jersey_number, team_id) VALUES ('RAJ Player 4', 4, 5);
INSERT INTO players (name, jersey_number, team_id) VALUES ('RAJ Player 5', 5, 5);
INSERT INTO players (name, jersey_number, team_id) VALUES ('RAJ Player 6', 6, 5);
INSERT INTO players (name, jersey_number, team_id) VALUES ('RAJ Player 7', 7, 5);

-- Team 6: Hyderabad Sultans
INSERT INTO players (name, jersey_number, team_id) VALUES ('HYD Player 1', 1, 6);
INSERT INTO players (name, jersey_number, team_id) VALUES ('HYD Player 2', 2, 6);
INSERT INTO players (name, jersey_number, team_id) VALUES ('HYD Player 3', 3, 6);
INSERT INTO players (name, jersey_number, team_id) VALUES ('HYD Player 4', 4, 6);
INSERT INTO players (name, jersey_number, team_id) VALUES ('HYD Player 5', 5, 6);
INSERT INTO players (name, jersey_number, team_id) VALUES ('HYD Player 6', 6, 6);
INSERT INTO players (name, jersey_number, team_id) VALUES ('HYD Player 7', 7, 6);



-- ===== MATCHES (Group Stage Schedule) =====
-- Group A — Turf 1
INSERT INTO matches (team1_id, team2_id, group_name, match_date, match_time, venue, status)
VALUES (1, 2, 'A', '2026-08-22', '09:00:00', 'Turf 1', 'SCHEDULED');

INSERT INTO matches (team1_id, team2_id, group_name, match_date, match_time, venue, status)
VALUES (1, 3, 'A', '2026-08-22', '10:00:00', 'Turf 1', 'SCHEDULED');

INSERT INTO matches (team1_id, team2_id, group_name, match_date, match_time, venue, status)
VALUES (2, 3, 'A', '2026-08-22', '11:00:00', 'Turf 1', 'SCHEDULED');

-- Group B — Turf 2
INSERT INTO matches (team1_id, team2_id, group_name, match_date, match_time, venue, status)
VALUES (4, 5, 'B', '2026-08-22', '09:00:00', 'Turf 2', 'SCHEDULED');

INSERT INTO matches (team1_id, team2_id, group_name, match_date, match_time, venue, status)
VALUES (4, 6, 'B', '2026-08-22', '10:00:00', 'Turf 2', 'SCHEDULED');

INSERT INTO matches (team1_id, team2_id, group_name, match_date, match_time, venue, status)
VALUES (5, 6, 'B', '2026-08-22', '11:00:00', 'Turf 2', 'SCHEDULED');