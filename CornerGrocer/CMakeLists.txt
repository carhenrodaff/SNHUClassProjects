cmake_minimum_required(VERSION 3.24)
project(CornerGrocer)

set(CMAKE_CXX_STANDARD 17)

add_executable(CornerGrocer main.cpp Inventory.h ui.cpp ui.h Inventory.cpp)
