Check if a keypad has easy to dial numbers

Defines the keypad in the constructor - takes in a 2D array representation of the keys on a keypad. This can be in any order eg:

1-2-3
4-5-6
7-8-9
*-0-#

or 

7-8-9
5-6-7
1-2-3
#-0-*

The class then calculates every keys adjacent keys on the keypad
eg:
1 = 1,2,4,5
2 = 1,2,3,4,5,6
3 = 2,3,5,6
...

This only needs to be done once for each keypad

Then searching becomes easier as you can search each list of numbers associated with the key instead of searching the keypad each time