#include <iostream>
#include <conio.h>
#include <windows.h>

using namespace std;

//height and width of the main game
const int height = 20;
const int width = 80;

int playerScore;//playerScore

int x, y;//snake head coordinates

int tailX[100], tailY[100];//snake tail coordinates

int fruitX, fruitY;//fruit coordinates

int poisonX, poisonY;// poision coordinates

int tailLength;//snake tail length

//storing snake moving snakeDirection
enum snakeDirection { STOP = 0, LEFT, RIGHT, UP, DOWN };

//snakeDirection variable
snakeDirection sDir;

bool gameOver;//gameOver variable

void initializeGame() {
	gameOver = false;
	sDir = STOP;
	x = width / 2;
	y = height / 2;
	fruitX = rand() % width;
	fruitY = rand() % height;
	poisonX = rand() % width;
	poisonY = rand() % height;
	playerScore = 0;
}

void gameRender(string playerName) {
	system("cls");

	for (int i = 0; i < width + 2; i++)
		cout << "-";
	cout << endl;

	for (int i = 0; i < height; i++) {
		for (int j = 0; j <= width; j++) {
			// Creating side walls with '|' 
			if (j == 0 || j == width)
				cout << "|";
			// Creating snake's head with 'O' 
			if (i == y && j == x)
				cout << "O";
			// Creating the sanke's food with '#' 
			else if (i == fruitY && j == fruitX)
				cout << "b";
			else if (i == poisonY && j == poisonX)
				cout << "x";
			// Creating snake's body with 'o' 
			else {
				bool prTail = false;
				for (int k = 0; k < tailLength; k++) {
					if (tailX[k] == j && tailY[k] == i) {
						cout << "o";
						prTail = true;
					}
				}
				if (!prTail)
					cout << " ";
			}
		}
		cout << endl;
	}

	for (int i = 0; i < width + 2; i++)
		cout << "-";
	cout << endl;

	cout << playerName << "'s Score: " << playerScore << endl;
}

void updateGame() {
	int prevX = tailX[0];
	int prevY = tailY[0];
	int prev2X, prev2Y;
	tailX[0] = x;
	tailY[0] = y;
	bool sameLoc;

	for (int i = 0; i < tailLength; i++) {
		prev2X = tailX[i];
		prev2Y = tailY[i];
		tailX[i] = prevX;
		tailY[i] = prevY;
		prevX = prev2X;
		prevY = prev2Y;
	}

	switch (sDir) {
	case LEFT: x--; break;
	case RIGHT: x++; break;
	case UP: y--; break;
	case DOWN: y++; break;
		break;
	}

	if (x >= width || x < 0 || y >= height || y < 0)
		gameOver = true;

	if (x == poisonX && y == poisonY)
		gameOver = true;

	if (x == fruitX && y == fruitY) {
		playerScore += 10;
		fruitX = rand() % width;
		fruitY = rand() % height;
		poisonX = rand() % width;
		poisonY = rand() % height;
		tailLength++;
	}

	for (int i = 0; i < tailLength; i++) {
		if (tailX[i] == x && tailY[i] == y)
			gameOver = true;
	}
}

void userInput() {
	if (_kbhit()) {
		switch (_getch()) {
		case 'a':
			sDir = LEFT;
			break;
		case 'd':
			sDir = RIGHT;
				break;
		case 's':
			sDir = DOWN;
			break;
		case 'w':
			sDir = UP;
			break;
		case 'x':
			gameOver = true;
			break;
		}
	}
}

int main() {
	string playerName;
	cout << "enter your name: ";
	cin >> playerName;

	initializeGame();
	while (!gameOver) {
		gameRender(playerName);
		userInput();
		updateGame();
		Sleep(200);
	}
	return 0;
}
