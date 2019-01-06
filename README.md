# SRM05

<b>1. Cibin Likes Networking</b><br>
<b>Prerequisites:</b>		Knowledge Of Star Topology<br>
<b>Difficulty:</b>			Very Easy<br>
<b>Solution Type:</b>		Simple Maths and Conditions<br>
<b>Star Topology</b><br>
<img src="https://www.computerhope.com/jargon/s/star.gif" /><br>
Alternatively referred to as a star network, star topology is one of the most common network setups. In this configuration, every node connects to a central network device, like a hub, switch, or computer.<br>
For each test case, find the sum of wire length required and also find the number of repeaters required. Now, subtract these quantities from available ones given. If any of them comes out to be negative then print insufficient otherwise print sufficient.<br>
<b>C Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/SRM05A.c<br>
<b>C++ Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/SRM05A.c<br>
<b>Python Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/SRM05A.py<br>
<b>Java Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/Srm05A.java<br>

<b>2. Cibin is confused between IPv4 and IPv6</b><br>
<b>Prerequisites:</b>		None<br>
<b>Difficulty:</b>			Medium<br>
<b>Solution Type:</b>		String Operations and Regular Expression<br>
For each test case, find out whether it contains a colon(:) or a dot(.). If none of them are present then print invalid. In case of dot check for the necessary conditions of Ipv4 address whereas in case of colon check for the necessary conditions of Ipv6  address. Also use of regular expressions can save your time.<br>
<b>C++ Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/SRM05B.c<br>
<b>Python Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/SRM05B.py<br>
<b>Java Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/Srm05B.java<br>
<b>Solution by Kaustubh Badrike</b><br>
http://arena.siesgst.ac.in/contest/SRM05/submission/5c32240ca97ba600223179a8<br>

<b>3. Installation of OS in New Computers</b><br>
<b>Prerequisites:</b>		Knowledge of Graph<br>
<b>Difficulty:</b>			Hard<br>
<b>Solution Type:</b>		Graph Coloring and Bipartite Check<br>
For each test case, we have to maintain an adjacency list instead of adjacency matrix to ignore TLE. Now at each step we need to keep track of the visited vertices and also the vertices where the OS is installed. Now depending on that we need to install OS in surrounding vertices. After each iteration, we need to check for the contradictions. The process continues till at all the the vertices OS is installed. Here the vertices corresponds to the computers. It is an example of Bipartite Graphs where no two vertices should share same color.<br>
<b>C++ Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/SRM05C.c<br>
<b>Python Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/SRM05C.py<br>
<b>Java Solution:</b><br>
https://github.com/vipul-08/SRM05/blob/master/SRM05A/Srm05C.java<br>
<b>Solution by Sanoop Menon</b><br>
http://arena.siesgst.ac.in/contest/SRM05/submission/5c321332a97ba60022317655
