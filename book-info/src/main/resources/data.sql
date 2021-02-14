INSERT IGNORE INTO language(name) VALUES('Hindi');
INSERT IGNORE INTO language(name) VALUES('English');

INSERT IGNORE INTO country(name) VALUES('India');
INSERT IGNORE INTO country(name) VALUES('United States of America');
INSERT IGNORE INTO country(name) VALUES('Brazil');
INSERT IGNORE INTO country(name) VALUES('The United Kingdom');
INSERT IGNORE INTO country(name) VALUES('England');


INSERT IGNORE INTO author(name) VALUES('Dale Carnegie');
INSERT IGNORE INTO author(name) VALUES('Stephen Hawking');
INSERT IGNORE INTO author(name) VALUES('J.K. Rowling');
INSERT IGNORE INTO author(name) VALUES('Charles Dickens');
INSERT IGNORE INTO author(name) VALUES('Paulo Coelho');
INSERT IGNORE INTO author(name) VALUES('Dan Brown');
INSERT IGNORE INTO author(name) VALUES('George S. Clason');
INSERT IGNORE INTO author(name) VALUES('Henry Chadwick');


INSERT IGNORE INTO category(type) VALUES('Personal-Developement');
INSERT IGNORE INTO category(type) VALUES('Science');
INSERT IGNORE INTO category(type) VALUES('Non Fiction');
INSERT IGNORE INTO category(type) VALUES('Mathematics');
INSERT IGNORE INTO category(type) VALUES('Classics');
INSERT IGNORE INTO category(type) VALUES('Fiction');
INSERT IGNORE INTO category(type) VALUES('History');
INSERT IGNORE INTO category(type) VALUES('Philosophy');
INSERT IGNORE INTO category(type) VALUES('Biography');
INSERT IGNORE INTO category(type) VALUES('Finance');
INSERT IGNORE INTO category(type) VALUES('Economics');
INSERT IGNORE INTO category(type) VALUES('Business');
INSERT IGNORE INTO category(type) VALUES('Mystery');
INSERT IGNORE INTO category(type) VALUES('Thriller');
INSERT IGNORE INTO category(type) VALUES('Suspense');
INSERT IGNORE INTO category(type) VALUES('Fantasy');
INSERT IGNORE INTO category(type) VALUES('Children');
INSERT IGNORE INTO category(type) VALUES('self Help');
INSERT IGNORE INTO category(type) VALUES('Physics');




INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('0091906814','How to Win Friends and Influence People',1,2,2,"You can go after the job you want...and get it! You can take the job you have...and improve it! You can take any situation you're in...and make it work for you!. 
Since its release in 1936, How to Win Friends and Influence People has sold more than 15 million copies. Dale Carnegie's first book is a timeless bestseller, packed with rock-solid advice that has carried thousands of now famous people up the ladder of success in their business and personal lives. As relevant as ever before, Dale Carnegie's principles endure, and will help you achieve your maximum potential in the complex and competitive modern age. 
Learn the six ways to make people like you, the twelve ways to win people to your way of thinking, and the nine ways to change people without arousing resentment.",'Vermilion',268,STR_TO_DATE('4-06-2006', '%d-%m-%Y'));


INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('439554896','Harry Potter and the Chamber of Secrets (Harry Potter  #2)',3,2,2,"Ever since Harry Potter had come home for the summer, the Dursleys had been so mean and hideous that all Harry wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he’s packing his bags, Harry receives a warning from a strange impish creature who says that if Harry returns to Hogwarts, disaster will strike.
And strike it does. For in Harry’s second year at Hogwarts, fresh torments and horrors arise, including an outrageously stuck-up new professor and a spirit who haunts the girls’ bathroom. But then the real trouble begins – someone is turning Hogwarts students to stone. Could it be Draco Malfoy, a more poisonous rival than ever? Could it possible be Hagrid, whose mysterious past is finally told? Or could it be the one everyone at Hogwarts most suspects… Harry Potter himself!
",'Scholastic',352,STR_TO_DATE('11-01-2003', '%d-%m-%Y'));

INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('60887966','The Alchemist',5,3,2,"Paulo Coelho's enchanting novel has inspired a devoted following around the world. This story, dazzling in its powerful simplicity and soul-stirring wisdom, is about an Andalusian shepherd boy named Santiago who travels from his homeland in Spain to the Egyptian desert in search of a treasure buried near the Pyramids. Along the way he meets a Gypsy woman, a man who calls himself king, and an alchemist, all of whom point Santiago in the direction of his quest. No one knows what the treasure is, or if Santiago will be able to surmount the obstacles in his path. But what starts out as a journey to find worldly goods turns into a discovery of the treasure found within. Lush, evocative, and deeply humane, the story of Santiago is an eternal testament to the transforming power of our dreams and the importance of listening to our hearts.",'HarperOne',192,STR_TO_DATE('05-02-2006', '%d-%m-%Y'));

INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('972859896','Angeles & Demons',6,2,2,"World-renowned Harvard symbologist Robert Langdon is summoned to a Swiss research facility to analyze a cryptic symbol seared into the chest of a murdered physicist. What he discovers is unimaginable: a deadly vendetta against the Catholic Church by a centuries-old underground organization -- the Illuminati. In a desperate race to save the Vatican from a powerful time bomb, Langdon joins forces in Rome with the beautiful and mysterious scientist Vittoria Vetra. Together they embark on a frantic hunt through sealed crypts, dangerous catacombs, and deserted cathedrals, and into the depths of the most secretive vault on earth...the long-forgotten Illuminati lair",'FonoLibro',736,STR_TO_DATE('12-01-2005', '%d-%m-%Y'));


INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('451205367','The Richest Man in Babylon',7,2,2,"Beloved by millions, this timeless classic holds the key to all you desire and everything you wish to accomplish. This is the book that reveals the secret to personal wealth.

The Success Secrets of the Ancients—
An Assured Road to Happiness and Prosperity",'Berkley Books',194,STR_TO_DATE('02-01-2008', '%d-%m-%Y'));

INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('192854526','Augustine: A Very Short Introduction',8,4,2,"Augustine was arguably the greatest early Christian philosopher. His teachings had a profound effect on Medieval scholarship, Renaissance humanism, and the religious controversies of both the Reformation and the Counter-Reformation. Here, Henry Chadwick places Augustine in his philosophical and religious context and traces the history of his influence on Western thought, both within and beyond the Christian tradition. A handy account to one of the greatest religious thinkers, this Very Short Introduction is both a useful guide for the one who seeks to know Augustine and a fine companion for the one who wishes to know him better.",'Oxford University Press  USA',144,STR_TO_DATE('06-07-2001', '%d-%m-%Y'));


INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('375760059','Bleak House',4,5,2,"Bleak House opens in the twilight of foggy London, where fog grips the city most densely in the Court of Chancery. The obscure case of Jarndyce and Jarndyce, in which an inheritance is gradually devoured by legal costs, the romance of Esther Summerson and the secrets of her origin, the sleuthing of Detective Inspector Bucket and the fate of Jo the crossing-sweeper, these are some of the lives Dickens invokes to portray London society, rich and poor, as no other novelist has done. Bleak House, in its atmosphere, symbolism and magnificent bleak comedy, is often regarded as the best of Dickens. A 'great Victorian novel', it is so inventive in its competing plots and styles that it eludes interpretation",'Modern Library',887,STR_TO_DATE('7-09-2002', '%d-%m-%Y'));

INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('762419229','God Created the Integers: The Mathematical Breakthroughs That Changed History',2,5,2,"In this collection of landmark mathematical works, editor Stephen Hawking has assembled the greatest feats humans have ever accomplished using just numbers and their brains.",'Running Press Book Publishers',1160,STR_TO_DATE('10-04-2005', '%d-%m-%Y'));


INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('553804367','A Brief History of Time',2,5,2,"In the ten years since its publication in 1988, Stephen Hawking's classic work has become a landmark volume in scientific writing, with more than nine million copies in forty languages sold worldwide. That edition was on the cutting edge of what was then known about the origins and nature of the universe. But the intervening years have seen extraordinary advances in the technology of observing both the micro- and the macrocosmic worlds. These observations have confirmed many of Professor Hawking's theoretical predictions in the first edition of his book, including the recent discoveries of the Cosmic Background Explorer satellite (COBE), which probed back in time to within 300,000 years of the universe's beginning and revealed wrinkles in the fabric of space-time that he had projected. Eager to bring to his original text the new knowledge revealed by these observations, as well as his own recent research, Professor Hawking has prepared a new introduction to the book, written an entirely new chapter on wormholes and time travel, and updated the chapters throughout.",'Bantam',176,STR_TO_DATE('27-09-2005', '%d-%m-%Y'));

INSERT IGNORE INTO book(isbn10,title,author_id,country_id,language_id,synopsis,publisher,print_length,publication_date) values ('691050848','The Nature of Space and Time',2,5,2,"Einstein said that the most incomprehensible thing about the universe is that it is comprehensible. But was he right? Can the quantum theory of fields and Einstein's general theory of relativity, the two most accurate and successful theories in all of physics, be united in a single quantum theory of gravity? Can quantum and cosmos ever be combined? On this issue, two of the world's most famous physicists--Stephen Hawking ('A Brief History of Time') and Roger Penrose ('The Emperor's New Mind" and "Shadows of the Mind')--disagree. Here they explain their positions in a work based on six lectures with a final debate, all originally presented at the Isaac Newton Institute for Mathematical Sciences at the University of Cambridge.",'Princeton University Press',152,STR_TO_DATE('10-08-2000', '%d-%m-%Y'));








INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (10,2);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (10,3);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (10,8);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (10,19);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (9,2);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (9,3);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (8,2);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (8,3);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (8,4);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (7,5);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (7,6);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (6,3);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (6,7);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (6,8);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (6,9);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (5,10);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (5,11);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (5,12);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (5,3);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (4,6);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (4,15);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (4,14);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (4,13);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (3,16);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (3,5);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (3,6);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (3,8);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (2,6);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (2,16);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (2,17);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (1,1);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (1,3);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (1,8);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (1,12);
INSERT IGNORE INTO book_category_mapping(book_id,category_id) values (1,18);




