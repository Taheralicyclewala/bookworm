INSERT IGNORE INTO language(name) VALUES('Hindi');
INSERT IGNORE INTO language(name) VALUES('English');

INSERT IGNORE INTO country(name) VALUES('India');
INSERT IGNORE INTO country(name) VALUES('United States of America');

INSERT IGNORE INTO author(name) VALUES('Dale Carnegie');
INSERT IGNORE INTO author(name) VALUES('Stephen King');
INSERT IGNORE INTO author(name) VALUES('J.K. Rowling');
INSERT IGNORE INTO author(name) VALUES('Charles Dickens');

INSERT IGNORE INTO category(type) VALUES('Personal-Developement');


INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('0091906814','How to Win Friends and Influence People',1,2,2,"You can go after the job you want...and get it! You can take the job you have...and improve it! You can take any situation you're in...and make it work for you!. 
Since its release in 1936, How to Win Friends and Influence People has sold more than 15 million copies. Dale Carnegie's first book is a timeless bestseller, packed with rock-solid advice that has carried thousands of now famous people up the ladder of success in their business and personal lives. As relevant as ever before, Dale Carnegie's principles endure, and will help you achieve your maximum potential in the complex and competitive modern age. 
Learn the six ways to make people like you, the twelve ways to win people to your way of thinking, and the nine ways to change people without arousing resentment.",'Vermilion',268,STR_TO_DATE('4-06-2006', '%d-%m-%Y'));



INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (0091906814,1);



