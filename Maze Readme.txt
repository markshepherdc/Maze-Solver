Mark Shepherd
CPTR 276

Maze Program

This program uses an undirected graph with the opennings
and legal moves in the graphs represented by verticies.

This program also is a modified version of Rodney Summerscale's 
UndirectedGraph and Directedgraph Classes.

The maze problem was solved by simply connecteing every edge in the graph,
and running a Dephth first search through the edges and verticies.

Then the print path method was able to give me a full map of where to go without
getting lost or trapped in the maze.

Visual Repreentation : Think of all the illegal moves and walls as "1's" and the
"0s" as every thing legal.

All the 0s are linked as verticies the sameway they are linked on the gragh
A search of a path from 0,0 to 0,7 is calles and traces the path.
 
________________________
{0, 0, 0, 0, 1, 0, 1, 0},
{1, 1, 1, 0, 0, 0, 1, 0},
{0, 0, 0, 0, 1, 1, 0, 0},
{1, 0, 1, 1, 0, 0, 0, 1},
{1, 0, 0, 0, 0, 1, 1, 0},
{0, 0, 1, 1, 1, 0, 0, 0},
{0, 1, 0, 0, 0, 0, 1, 0},
{0, 0, 0, 1, 1, 0, 1, 0}};

Output Sample

> run GraphExample
 The Directions through the maze are: 
0,0, 0,1, 0,2, 0,3, 1,3, 2,3, 2,2, 2,1, 3,1, 4,1, 5,1, 5,0, 6,0, 7,0, 7,1, 7,2, 6,2, 6,3, 6,4, 6,5, 5,5, 5,6, 5,7, 6,7, 7,7 

