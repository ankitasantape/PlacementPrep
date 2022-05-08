/*
Given a singly linklist, remove the nth node from the end of the list and return its head.
Input Format
1->7->2->6->3->5->4->null
2
Output Format
1->7->2->6->3->4->null
Constraints
1 <= size Of LinkedList <= 10^6
1 <= n <= 10^6
Sample Input
9
18 1 16 11 15 7 9 16 4 
1
Sample Output
18 1 16 11 15 7 9 16 
 
Sample Input
531
218 370 476 733 1803 585 1869 289 227 448 1536 1103 285 1329 1752 440 1207 1144 1874 1926 120 387 1057 72 1 1238 1862 1018 223 796 1004 1827 1210 1352 30 1112 1182 1640 710 1294 867 411 1490 1804 1067 393 1108 719 1175 1665 503 1896 1350 48 1002 448 1787 237 74 715 1130 1666 80 682 112 1172 675 1035 1964 1411 748 555 205 141 69 411 1753 1565 492 1056 1015 1506 1482 1748 1481 1322 1210 523 666 477 968 640 112 357 1512 1245 1806 587 1520 1865 185 701 899 1308 1941 155 1691 1214 1099 482 1138 734 1305 1424 1357 1343 1254 1909 1494 1292 384 1962 1364 635 500 1356 1721 1680 1001 769 1208 248 218 171 305 742 1614 986 1562 923 1990 1147 507 558 466 302 198 75 208 1910 1362 423 1602 1482 83 1778 1067 1048 935 1989 1126 521 927 107 946 464 1080 1452 1534 1787 1253 805 461 316 843 1875 1798 1330 424 1997 587 1280 1681 2 1492 1215 887 1912 1656 351 885 307 679 1704 1273 1174 438 912 876 1636 1959 1461 1920 1407 1205 873 1285 1458 761 1070 1464 506 1468 663 1752 734 1898 1918 1942 1360 79 164 728 156 1425 227 1162 1757 937 431 579 63 1999 891 943 975 1969 1303 1118 734 1487 1479 1016 1588 1414 735 1627 1874 1432 283 99 1504 1525 1147 308 1237 1560 1372 247 756 1039 641 751 627 1352 640 1479 680 1717 1801 1386 508 1884 1409 494 993 1118 1629 1837 1472 18 762 994 1770 1581 1737 1293 241 1791 1159 1138 847 1613 1291 516 1668 1767 713 154 1661 1574 1075 1996 1455 1140 111 716 1492 1863 1332 595 828 427 382 1735 180 603 481 230 836 268 634 1025 1154 199 32 600 1445 512 1530 142 772 1527 1546 1433 1164 539 1639 376 1344 326 1240 1361 1627 1673 28 1878 97 756 1447 899 627 306 535 1095 1570 1375 1077 1981 1467 39 1558 726 1424 973 1361 1252 7 196 779 1461 635 846 1614 1866 784 574 600 1571 981 1916 1232 1882 578 724 1251 1816 193 1979 684 583 1369 1312 1923 134 1012 907 444 594 147 1109 240 855 1752 275 73 1043 1056 832 342 115 884 725 222 1053 580 872 1506 1673 308 271 1531 1004 1059 495 1203 626 1926 421 1487 535 196 304 1482 547 1722 873 1885 352 1119 1201 1161 1097 1777 1813 1351 1312 78 256 1271 476 15 1374 486 1198 1599 1896 1323 1902 777 1792 1327 695 79 1531 1036 843 1063 262 222 1828 1872 1654 951 1353 258 272 1679 761 1667 1441 1064 1174 566 1372 1279 1041 511 1214 1870 1247 737 1167 671 1333 1768 1176 123 1125 1186 11 1985 1716 1399 1475 306 39 154 1705 296 346 1624 864 631 1068 1950 1902 1756 1499 1127 1751 914 103 1634 551 1155 1110 578 1484 459 83 
531
Sample Output
370 476 733 1803 585 1869 289 227 448 1536 1103 285 1329 1752 440 1207 1144 1874 1926 120 387 1057 72 1 1238 1862 1018 223 796 1004 1827 1210 1352 30 1112 1182 1640 710 1294 867 411 1490 1804 1067 393 1108 719 1175 1665 503 1896 1350 48 1002 448 1787 237 74 715 1130 1666 80 682 112 1172 675 1035 1964 1411 748 555 205 141 69 411 1753 1565 492 1056 1015 1506 1482 1748 1481 1322 1210 523 666 477 968 640 112 357 1512 1245 1806 587 1520 1865 185 701 899 1308 1941 155 1691 1214 1099 482 1138 734 1305 1424 1357 1343 1254 1909 1494 1292 384 1962 1364 635 500 1356 1721 1680 1001 769 1208 248 218 171 305 742 1614 986 1562 923 1990 1147 507 558 466 302 198 75 208 1910 1362 423 1602 1482 83 1778 1067 1048 935 1989 1126 521 927 107 946 464 1080 1452 1534 1787 1253 805 461 316 843 1875 1798 1330 424 1997 587 1280 1681 2 1492 1215 887 1912 1656 351 885 307 679 1704 1273 1174 438 912 876 1636 1959 1461 1920 1407 1205 873 1285 1458 761 1070 1464 506 1468 663 1752 734 1898 1918 1942 1360 79 164 728 156 1425 227 1162 1757 937 431 579 63 1999 891 943 975 1969 1303 1118 734 1487 1479 1016 1588 1414 735 1627 1874 1432 283 99 1504 1525 1147 308 1237 1560 1372 247 756 1039 641 751 627 1352 640 1479 680 1717 1801 1386 508 1884 1409 494 993 1118 1629 1837 1472 18 762 994 1770 1581 1737 1293 241 1791 1159 1138 847 1613 1291 516 1668 1767 713 154 1661 1574 1075 1996 1455 1140 111 716 1492 1863 1332 595 828 427 382 1735 180 603 481 230 836 268 634 1025 1154 199 32 600 1445 512 1530 142 772 1527 1546 1433 1164 539 1639 376 1344 326 1240 1361 1627 1673 28 1878 97 756 1447 899 627 306 535 1095 1570 1375 1077 1981 1467 39 1558 726 1424 973 1361 1252 7 196 779 1461 635 846 1614 1866 784 574 600 1571 981 1916 1232 1882 578 724 1251 1816 193 1979 684 583 1369 1312 1923 134 1012 907 444 594 147 1109 240 855 1752 275 73 1043 1056 832 342 115 884 725 222 1053 580 872 1506 1673 308 271 1531 1004 1059 495 1203 626 1926 421 1487 535 196 304 1482 547 1722 873 1885 352 1119 1201 1161 1097 1777 1813 1351 1312 78 256 1271 476 15 1374 486 1198 1599 1896 1323 1902 777 1792 1327 695 79 1531 1036 843 1063 262 222 1828 1872 1654 951 1353 258 272 1679 761 1667 1441 1064 1174 566 1372 1279 1041 511 1214 1870 1247 737 1167 671 1333 1768 1176 123 1125 1186 11 1985 1716 1399 1475 306 39 154 1705 296 346 1624 864 631 1068 1950 1902 1756 1499 1127 1751 914 103 1634 551 1155 1110 578 1484 459 83 

*/

package Linked_List;

import java.util.Scanner;

public class A09_Remove_Nth_Node_From_End_Of_Linked_List {
    
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;
		ListNode(){
			
		}
		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 1;
		ListNode dh = new ListNode(-1); // dummy head
		ListNode dt = dh;
		dt.next = head;
		ListNode slow = dt;
		ListNode fast = dt;
		while(i <= n) {
			fast = fast.next;
			i++;
		}
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
	    slow.next = slow.next.next;
		
		return dh.next;
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode createList(int n) {
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (n-- > 0) {
			prev.next = new ListNode(scn.nextInt());
			prev = prev.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		int n = scn.nextInt();
		ListNode h1 = createList(n);

		int m = scn.nextInt();
		h1 = removeNthFromEnd(h1, m);
		printList(h1);
	}
}
