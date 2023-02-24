//
// Created by caheroaf on 2/8/23.
//
// This following program contains all frontend functions.
#include <iostream>
#include "ui.h"
#include "Inventory.h"

using namespace std;

void ui::menuGenerator() {
    generateFormat(51, '.');
    cout << endl;
    generateFormat(21, '.');
    cout << "Inventory";
    generateFormat(21, '.');
    cout << endl << endl;
    cout << "1. Search for Occurrence of Searched Item." << endl
         << "2. Print Unique Items and Frequency." << endl
         << "3. Print Histogram." << endl
         << "4. Quit" << endl;
}

void ui::generateFormat(int numberOf, char fill) {
    for (int i = 0; i < numberOf; i++) {
        cout << fill;
    }
}

void ui::mainMenu() {
    bool programStatus = true;
    int userInput;
    class Inventory inventory;
    try {
        while (programStatus) {
            menuGenerator();
            cin >> userInput;
            switch (userInput) {
                case 1:
                    //TODO:Implement name of item and return frequency X
                    inventory.searchItem();
                    break;
                case 2:
                    //TODO:Implement frequency and names of all items X
                    inventory.returnAll();
                    break;
                case 3:
                    //TODO:Implement histogram
                    inventory.printHisto();
                    break;
                case 4:
                    programStatus = false;
                   // inventory.writeToFile();
                    break;
                default:
                    cout << "Please enter one of the above numbers.";
                    break;

            }
        }
    }
    catch (...) {
        cout << "An unexpected error has occurred, please try again.";
        cin.clear();
        cin.ignore(10000, '\n');
    }
}