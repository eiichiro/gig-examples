/*
 * Copyright (C) 2011-2014 Eiichiro Uchiumi. All Rights Reserved.
 */

/** Gets posted comment list ordered by the posted date. */
function list() {
//	var path = '../GuestbookEndpoint/list';
	var path = '../api/comments';
	$.getJSON(path, function(comments) {
		var timeout = 0;
		$('.col').empty();
		$.each(comments, function(i, comment) {
			var $text = $('<div/>').addClass('comment-text');
			var length = comment.text.length;
			
			if (length < 50) {
				$text.addClass('comment-text-font-lg');
			} else if (length < 100) {
				$text.addClass('comment-text-font-md');
			} else if (length < 150) {
				$text.addClass('comment-text-font-sm');
			} else {
				$text.addClass('comment-text-font-xs');
			}
			
			$text.html(comment.text.replace(/(s?https?:\/\/[-_.!~*'()a-zA-Z0-9;\/?:\@&=+\$,%#]+)/gi, '<a href="$1" target="_blank">$1</a>'));
			
			var $posted = $('<span/>').addClass('comment-date-posted-at').text('posted at');
			var $date = $('<div/>').addClass('comment-date');
			$date.append($posted).append(comment.date);
			
			var $comment = $('<div/>').addClass('comment');
			$comment.append($text);
			$comment.append($date);
			$comment.hover(function() {
				$(this).children('.comment-date').fadeIn();
			}, function() {
				$(this).children('.comment-date').fadeOut();
			});
			
			$('#col-' + ((i % col) + 1)).append($comment);
			setTimeout(function() {
				$comment.fadeIn();
			}, timeout);
			timeout = timeout + 400;
		});
	});
}

/** Posts a new comment. */
function post() {
	var comment = $('#compose-comment').val().trim();
	
	if (!comment) {
		alert('Comment must not be empty');
		return;
	}
	
	if (comment.length > 200) {
		alert('Comment must be within 200 characters');
		return;
	}
	
//	var path = '../GuestbookEndpoint/post';
	var path = '../api/comment';
	$.post(path, {text: comment}, function() {
		$('#compose-comment').val('');
		$('#compose-alert').empty();
		list();
		$('#compose').modal('hide');
	}).error(function() {
		alert('Oops, unexpected error occurred while processing your post :(');
	});
}

/** Displays an alert message. */
function alert(message) {
	$('#compose-alert').empty().append(message);
}

var col = 4;

// Detecting the number of columns to display according to the device width. Runs on page load.
$(function() {
	$('#compose-post').click(post);
	
	if (window.matchMedia) {
		if (window.matchMedia('(max-width: 768px)').matches) {
			col = 1;
		} else if (window.matchMedia('(min-width: 768px) and (max-width: 992px)').matches) {
			col = 2;
		} else if (window.matchMedia('(min-width: 992px) and (max-width: 1200px)').matches) {
			col = 3;
		} else {
			// (min-width: 1200px)
		}
	}
	
	list();
});
