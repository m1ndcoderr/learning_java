-- trying to select all comments with id = 1.

SELECT c.comment_text, a.application_id, u.user FROM comments AS c
INNER JOIN applications AS a ON c.application_id = a.application_id
INNER JOIN users AS u ON a.user_id = u.user_id
WHERE c.application_id = 1;