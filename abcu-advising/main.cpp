#include <vector>
#include <iostream>
#include <string>
#include <fstream>
#include <climits>
#include <sstream>


int defaultTableSize = 10;

class HashTable {
    struct Course {
        std::string courseNum;
        std::string name;
        std::string prereq1;
        std::string prereq2;

        Course() {
            courseNum = "-1";
            name = "noname";
            prereq1 = "noname1";
            prereq2 = "noname2";
        }

    };

    struct Node {
        Course course;
        int key;
        Node* next;

        Node() : key(UINT_MAX), next(nullptr) {}

        Node(Course course) : Node() {
            this->course = course;
        }

        Node(Course course, int key) : Node() {
            this->course = course;
            this->key = key;
        }
    };

    std::vector<Node> courses;

    void parseText();

    int hash(int key);

    void Insert(Course course);

    static int partition(std::vector<Node> &array, int start, int end);

    void quickSort(std::vector<Node> &array, int start, int end);

    void PrintAlphanumeric(std::vector<Node> array);

public:
    void menu();

    void Search(std::string courseNumSearch);
};

void HashTable::parseText() {
    try {
        using namespace std;
        string fileName;
        string line;
        bool commaNotFoundFlag = false;
        bool recentEntryFlag = false;
        int commaCount = 0;
        int commaLocation;
        string info;
        string userInput;

        // Declarations
        courses.resize(defaultTableSize);
        cout << "Please enter the file name as it is written in your file system." << endl;
        cin >> userInput;
        ifstream inputFile(userInput);
        if(!inputFile.is_open()){
            throw runtime_error("File not found.");
        }
        if ((inputFile.bad())) {
            throw runtime_error("error while opening file");
        }
        Course currentCourse;

        while (getline(inputFile, line)) {
            istringstream iss(line);
            commaCount = 0; // Reset comma count for each line1
            while (getline(iss, line, ',')) {
                switch (commaCount) {
                    case 0:
                        currentCourse.courseNum = line;
                        break;
                    case 1:
                        currentCourse.name = line;
                        break;
                    case 2:
                        currentCourse.prereq1 = line;
                        break;
                    case 3:
                        currentCourse.prereq2 = line;
                        break;
                    default:
                        throw runtime_error("entered default path during loading");
                }
                commaCount++;
            }
            commaCount = 0;
            Insert(currentCourse);
        }

    inputFile.close();
    }
    catch (std::runtime_error& e) {
        std::cerr << e.what() << std::endl;
    }
}
int HashTable::hash(int key){
    return key % defaultTableSize;
}
void HashTable::Insert(Course course) {
    int NewKeyToAssign = 0;
    for(char c : course.courseNum){
        NewKeyToAssign += int(c);
    }
    NewKeyToAssign = hash(NewKeyToAssign);
    auto itr = next(courses.begin(),NewKeyToAssign);

    for (; itr < courses.end(); ++itr) {
        if (itr->key == UINT_MAX) {
            // if no entry found for the key
            itr->key = NewKeyToAssign;
            itr->course = course;
            itr->next = nullptr;
            break;

        } else if (itr->next == nullptr) {
            // else if node is not used
            Node* newNode = new Node(course, NewKeyToAssign);
            itr->next = newNode;
            break;

        } else {
            while(itr->next != nullptr) {
                next(itr, 1);
            }
            itr->next = new Node(course, NewKeyToAssign);
        }
    }
}
int HashTable::partition(std::vector<Node> &array, int start, int end) {
    Node reference = array.at(start);
    std::string pivot = reference.course.courseNum;
    int count = 0;

    for (int i = start + 1; i <= end; i++) {
        if (array.at(i).course.courseNum <= pivot) {
            count++;
        }
    }
    int pivotIndex = start + count;
    std::swap(array.at(pivotIndex), array.at(start));

    int i = start, j = end;

    while (i < pivotIndex && j > pivotIndex){
        while (array.at(i).course.courseNum <= pivot) {
            i++;
        }
        while (array.at(j).course.courseNum > pivot){
            j--;
        }
        if ( i < pivotIndex && j > pivotIndex) {
            std::swap(array.at(i++), array.at(j--));
        }
    }
    return pivotIndex;
}
void HashTable::quickSort(std::vector<Node> &array, int start, int end){
    if (start >= end){
        return;
    }
    int mid = partition(array, start, end);

    quickSort(array, start, mid - 1);

    quickSort(array, mid + 1, end);
}
void HashTable::PrintAlphanumeric(std::vector<Node> array) {
    int pos = 0;
    std::vector<Node> newVector;
    auto itr = array.begin();
    for (; itr != array.end(); ++itr) {
        if(itr->key != -1){
            newVector.push_back(array.at(pos));
            if(itr->next  != nullptr){
                newVector.push_back(array.at(pos).next->course);
            }
        }
        ++pos;
    }
    int q1 = 0;
    int q2 = 0;
    std::string nameLength1;
    std::string nameLength2;
    for (auto itr = newVector.begin(); itr != newVector.end(); ++itr) {
        if (itr->course.courseNum != "noname") {
            nameLength1 = itr->course.courseNum;
            break;
        }
    }
    for (auto itr = newVector.end() - 1; itr != newVector.begin(); --itr) {
        if (itr->course.courseNum != "noname") {
            nameLength2 = itr->course.courseNum;
            break;
            }
        }
    for(char i : nameLength1){
        q1 += int(i);
    }
    for(char i : nameLength2){
        q2 += int(i);
    }
    quickSort(newVector, 0, newVector.size() - 1);
    for(auto & itr : newVector){
            std::cout << itr.course.courseNum << ", " << itr.course.name << std::endl;
    }
}
void HashTable::Search(std::string courseNumSearch){
    int NewKeyToAssign = 0;
    for(char c : courseNumSearch){
        NewKeyToAssign += int(c);
    }
    NewKeyToAssign = hash(NewKeyToAssign);
    if (courses.at(NewKeyToAssign).key == UINT_MAX) {
            // if no entry found for the key
            std::cout << "No entry found.\n";
        }
    else{
        if(courses.at(NewKeyToAssign).course.courseNum != courseNumSearch){
            std::cout << "Name: " << courses.at(NewKeyToAssign).next->course.name << std::endl;
            if(courses.at(NewKeyToAssign).course.prereq1 != "noname1"){
                std::cout << "Prerequisite 1: " << courses.at(NewKeyToAssign).next->course.prereq1 << std::endl;
                if(courses.at(NewKeyToAssign).course.prereq2 != "noname2"){
                    std::cout << "Prerequisite 2: " << courses.at(NewKeyToAssign).next->course.prereq2 << std::endl;
                }
            }
        }
        std::cout << "Name: " << courses.at(NewKeyToAssign).course.name << std::endl;
        if(courses.at(NewKeyToAssign).course.prereq1 != "noname1"){
            std::cout << "Prerequisite 1: " << courses.at(NewKeyToAssign).course.prereq1 << std::endl;
            if(courses.at(NewKeyToAssign).course.prereq2 != "noname2"){
                std::cout << "Prerequisite 2: " << courses.at(NewKeyToAssign).course.prereq2 << std::endl;
            }
        }
        }
    }
void HashTable::menu(){
    int choice;
    std::string inputchoice;
    bool hasLoaded = false;
    bool sentinel = true;
    while(sentinel) {
        std::cout << "Welcome to the Course Planner" << std::endl;
        std::cout << "1. Load Data Structures." << std::endl;
        std::cout << "2. Print Course Structures." << std::endl;
        std::cout << "3. Print Course." << std::endl;
        std::cout << "9. Exit" << std::endl;
        std::cin >> choice;
        if(std::cin.fail()){
            std::cin.clear();
            std::cin.ignore(INT_MAX, '\n');
        }
        switch(choice){
            case 1:
                parseText();
                hasLoaded = true;
                break;
            case 2:
                if(!hasLoaded){
                    std::cout << "Structure has not been initialized.\n";
                    break;
                }
                std::cout << "Here is a sample schedule.\n";
                PrintAlphanumeric(courses);
                break;
            case 3:
                if(!hasLoaded){
                    std::cout << "Structure has not been initialized.\n";
                    break;
                }
                std::cout << "Enter the course name.\n";
                std::cin >> inputchoice;
                for(int i = 0; i < inputchoice.length() - 1; ++i){
                    if(islower(inputchoice.at(i))){
                       inputchoice.at(i) = toupper(inputchoice.at(i));
                    }
                }
                Search(inputchoice);
                break;
            case 9:
                sentinel = false;
            default:
                std::cout << "That is not a valid entry." << std::endl;
        }

    }
}
int main(){
    auto init = new HashTable;
    init->menu();
    return 0;
}