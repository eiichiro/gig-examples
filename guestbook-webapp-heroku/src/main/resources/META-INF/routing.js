// URL routing of the application.
routing = new Routing();
routing.ignore('*.js', '*.css', '*.gif', '*.png', '*.jpg', '*.jsp', '*.html');
routing.add('/api/comment', Packages.gig.examples.guestbook.GuestbookEndpoint, 'post');
routing.add('/api/comments', Packages.gig.examples.guestbook.GuestbookEndpoint, 'list');
