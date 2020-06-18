"""
Final Project Part One
Max Heinzelman
Gage Gutmann

Best Friend Chain will use Dijkstra's algorithm, but instead of trying to
find the least expensive path we will find the most expensive path.
Meaning we will try and follow the graph where it is weighted higher rather
than where it is weighted lower.

Special Feature 1:
    Determine all of the friend triangles in the graph. A friend triangle involves
    3 people in which friend1 --> friend2 --> friend3 -> friend1. You would want
    to know if you had a friend who wasn't friends with you but was friends with 
    someone you dont like, but they like you. Confusing to think about.
    https://www.geeksforgeeks.org/wp-content/uploads/triangles.png

Special Feature 2:
    Find all reccommended friends. This function will ask you to enter a rating
    that you want all of the reccomended friends to be above, and then it will return
    all friends of your friends that you are not yet friends with. This will use an 
    apdaptation of Depth First Search.
"""

import sys
import parser as Parser
import Graph as Graph

def open_file(filename):
    try:
        return open(filename)
    except FileNotFoundError:
        print('invalid filename %s' % filename)
        exit(1)

def parse(fopen):
    p = Parser.Parser(fopen)
    nodes = p.parse()

    return nodes


def add_nodes(nodes, graph):
    for node in nodes:
        graph.add_edge(node[0], node[1], node[2])


def print_menu():
    print('\nWhat do you want to do?')
    print('1) Check if user exists')
    print('2) Check connection between users')
    print('3) Quit')
    print('> ', end='')

def user_exists(friend_net):
    print("Please enter a name.")
    name = input()

    if friend_net.user_exists(name):
        print('User with name "%s" exists.' %name)
    else:
        print('User with name "%s" does not exist.' %name)

def connection_exists(friend_net):
    print('Enter name 1: ')
    name1 = input()
    print('Enter name 2: ')
    name2 = input()

    friend_net.connection_exists(name1, name2)


def main():
    #make sure there is an input file
    if len(sys.argv) != 2:
        print('Usage: python3 part1.py FILE_NAME')
        exit(1)

    #parse input file
    fopen = open_file(sys.argv[1])
    nodes = parse(fopen)
    print(nodes)

    #add the nodes to the graph
    friend_net = Graph.Graph()
    add_nodes(nodes, friend_net)

    run = True
    while run:
        #get input
        print_menu()
        choice = input()
        if choice.isalpha():
            print('Please enter a number.')
        else:
            #do what is requested by user
            choice = int(choice)
            if choice == 1:
                user_exists(friend_net)
            elif choice == 2:
                connection_exists(friend_net)
            elif choice == 3:
                run = False
            else:
                print('Enter a number from 1-3.')
            
    fopen.close()

main()
