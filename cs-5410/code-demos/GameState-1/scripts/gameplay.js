/*jslint browser: true, white: true, plusplus: true */
/*global MYGAME, console, KeyEvent, requestAnimationFrame, performance */
MYGAME.screens['game-play'] = (function() {
	'use strict';
	
	var mouseCapture = false,
		myMouse = MYGAME.input.Mouse(),
		myKeyboard = MYGAME.input.Keyboard(),
		myTexture = null,
		cancelNextRequest = false;
	
	function initialize() {
		console.log('game initializing...');

		myTexture = MYGAME.graphics.Texture( {
			image : MYGAME.images['images/USU-Logo.png'],
			center : { x : 100, y : 100 },
			width : 100, height : 100,
			rotation : 0,
			moveRate : 200,			// pixels per second
			rotateRate : 3.14159	// Radians per second
		});

		//
		// Create the keyboard input handler and register the keyboard commands
		myKeyboard.registerCommand(KeyEvent.DOM_VK_A, myTexture.moveLeft);
		myKeyboard.registerCommand(KeyEvent.DOM_VK_D, myTexture.moveRight);
		myKeyboard.registerCommand(KeyEvent.DOM_VK_W, myTexture.moveUp);
		myKeyboard.registerCommand(KeyEvent.DOM_VK_S, myTexture.moveDown);
		myKeyboard.registerCommand(KeyEvent.DOM_VK_Q, myTexture.rotateLeft);
		myKeyboard.registerCommand(KeyEvent.DOM_VK_E, myTexture.rotateRight);
		myKeyboard.registerCommand(KeyEvent.DOM_VK_ESCAPE, function() {
			//
			// Stop the game loop by canceling the request for the next animation frame
			cancelNextRequest = true;
			//
			// Then, return to the main menu
			MYGAME.game.showScreen('main-menu');
		});
		
		//
		// Create an ability to move the logo using the mouse
		myMouse = MYGAME.input.Mouse();
		myMouse.registerCommand('mousedown', function(e) {
			mouseCapture = true;
			myTexture.moveTo({x : e.clientX, y : e.clientY});
		});

		myMouse.registerCommand('mouseup', function() {
			mouseCapture = false;
		});

		myMouse.registerCommand('mousemove', function(e) {
			if (mouseCapture) {
				myTexture.moveTo({x : e.clientX, y : e.clientY});
			}
		});
	}
	
	//------------------------------------------------------------------
	//
	// This is the Game Loop function!
	//
	//------------------------------------------------------------------
	function gameLoop(time) {
		MYGAME.elapsedTime = time - MYGAME.lastTimeStamp;
		MYGAME.lastTimeStamp = time;

		myKeyboard.update(MYGAME.elapsedTime);
		myMouse.update(MYGAME.elapsedTime);

		MYGAME.graphics.clear();
		myTexture.draw();

		if (!cancelNextRequest) {
			requestAnimationFrame(gameLoop);
		}
	}
	
	function run() {
		MYGAME.lastTimeStamp = performance.now();
		//
		// Start the animation loop
		cancelNextRequest = false;
		requestAnimationFrame(gameLoop);
	}
	
	return {
		initialize : initialize,
		run : run
	};
}());
