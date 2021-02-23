// package ETC;

// import java.util.*;

// /*
// * select
// *
// ifnull(customer_name,"N/A"),ifnull(product_name,"N/A"),ifnull(ii.quantity,0)
// * from customer as c left outer join invoice as i on c.id=i.customer_id left
// * outer join invoice_item as ii on i.id=ii.invoice_id right outer join
// product
// * as p on ii.product_id=p.id order by c.id,p.id,ii.id;
// */

// class Road implements Comparable<Road> {
// int num;
// int cost;

// Road(int num, int cost) {
// this.num = num;
// this.cost = cost;
// }

// @Override
// public int compareTo(Road r) {
// return cost - r.cost;
// }
// }

// class Solution {
// List<Road>[] list;
// int[] costs;
// List<Integer>[] route;

// public int solution(int n, int s, int a, int b, int[][] fares) {
// int answer = 0;
// list = new ArrayList[n + 1];
// for (int i = 0; i < n + 1; i++) {
// list[i] = new ArrayList<>();
// }

// for (int i = 0; i < fares.length; i++) {
// int c = fares[i][0];
// int d = fares[i][1];
// int f = fares[i][2];
// list[c].add(new Road(d, f));
// list[d].add(new Road(c, f));
// }

// findCosts(s, a);
// int[] A = findRoute(s, a);
// int minA = costs[a];

// findCosts(s, b);
// int[] B = findRoute(s, b);
// int minB = costs[b];

// int same = 0;
// int length = Math.min(A.length, B.length);
// for (int i = 1; i < length; i++) {
// if (A[i] != B[i]) {
// same = costs[B[i - 1]];
// break;
// }
// }
// answer = minA + minB - same;
// return answer;
// }

// public void findCosts(int start, int end) {
// route = new ArrayList[list.length];
// for (int i = 0; i < route.length; i++) {
// route[i] = new ArrayList<>();
// }
// costs = new int[list.length];
// Arrays.fill(costs, Integer.MAX_VALUE);

// PriorityQueue<Road> pq = new PriorityQueue<>();
// pq.add(new Road(start, 0));
// costs[start] = 0;

// while (!pq.isEmpty()) {
// Road cur = pq.poll();
// for (Road r : list[cur.num]) {
// int newCost = costs[cur.num] + r.cost;
// if (newCost < costs[r.num]) {
// costs[r.num] = newCost;
// pq.add(new Road(r.num, costs[r.num]));
// route[r.num].add(cur.num);
// System.out.println("route idx : " + r.num + "/" + cur.num);
// }
// }
// }
// }

// public int[] findRoute(int start, int end) {
// List<Integer> result = new ArrayList<>();
// int now = end;
// result.add(now);
// while (now == start) {
// for (int i = list[now].size() - 1; i >= 0; i++) {
// result.add(route[now].get(i));
// }
// }
// int[] ret = new int[result.size()];
// for (int i = result.size() - 1; i >= 0; i--) {
// ret[result.size() - 1 - i] = result.get(i);
// }
// return ret;
// }
// }