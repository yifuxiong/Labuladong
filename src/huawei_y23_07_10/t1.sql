# select max(gpa) ad gpa from user_profile where university='复旦大学';

select gpa from user_profile where university='复旦大学' order by gpa desc limit 1;
