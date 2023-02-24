//
// Created by caheroaf on 2/8/23.
//
// This following program contains all backend functions.
#include <map>
#include <limits>
#include <iostream>
#include <fstream>
#include "Inventory.h"
#include "ui.h"
#include <string>

using namespace std;


map<string, int> stock;

string sKeyPair = " ";
int iKeyPair = 0;

void Inventory::initializeProgram() {

    string line;
    ifstream dataFile;
    ui UI;

    dataFile.open("frequency.dat");

    if (!dataFile.is_open()){
        cout << "frequency.dat not found" << endl;
    }
    //checks to see if the file is open, then will check if frequency.dat is in format "string number".It does this by checking to see if there is a white space. If it is, map will be populated by looking for spaces
    //then placed in order. Finally, if it isn't, it will count each unique entry and format it properly.
    if (dataFile.is_open()) {
        cout << "frequency.dat opening..." << endl;
        while (getline(dataFile, line)) {
            if(line.find(' ') == string::npos) {
                sKeyPair = line;
                if (stock.count(sKeyPair)) {
                    stock[sKeyPair] = stock[sKeyPair] + 1;
                } else {
                    stock.emplace(sKeyPair, 1);
                }
            }
            else {
                dataFile >> sKeyPair >> iKeyPair;
                stock.emplace(sKeyPair, iKeyPair);
                dataFile.clear();
                dataFile.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
            }
            
           /* if (!dataFile){
                cout << "Broke" << endl;
                break;
            }
*/

        }
    }
    dataFile.close();
    UI.mainMenu();
    closeProgram();

}
void Inventory::closeProgram() {
    ofstream writeFile;
    writeFile.open("frequency.dat");
    //Writing to file and quitting
    for (auto i = stock.begin(); i != stock.end(); ++i) {
        writeFile << i->first << " " << i->second << endl;
    }
    writeFile.close();
}
void Inventory::searchItem() {
    string uInput;
    try {
        cout << "What would you like to search for? (plural)" << endl;
        cin >> uInput;
        for (int i = 0; i < uInput.size(); ++i) {
            uInput[i] = tolower(uInput[i]);
        }
        uInput[0] = toupper(uInput[0]);
        auto it = stock.find(uInput);
        if (it != stock.end()) {
            cout << it->first << " " << it->second << endl;
        } else {
            cout << "item not found" << endl;
        }
    }
    catch (...) {

    }
}

void Inventory::returnAll() {
    for (auto i = stock.begin(); i != stock.end(); ++i) {
        cout << i->first << " " << i->second << endl;
    }
}

void Inventory::printHisto() {
    ui UI;
    for (auto i = stock.begin(); i != stock.end(); ++i) {
        cout << i->first;
        UI.generateFormat(i->second, '*');
        cout << endl;
    }
};