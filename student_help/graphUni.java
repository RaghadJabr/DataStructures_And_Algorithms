package student_help;

public class graphUni {
	private node[] adjacencyList;
	private building[] buildings;
	private int numVertices;

	public graphUni(int numVertices) {
		this.numVertices = numVertices;
		adjacencyList = new node[numVertices];
		buildings = new building[numVertices];
	}

	public void addBuilding(int id, String name) {
		buildings[id] = new building(id, name);
	}

	public void addEdge(int source, int destination, int weight) {
		node newNode = new node(destination, weight);
		if (adjacencyList[source] == null) {
			adjacencyList[source] = newNode;
		} else {
			node current = adjacencyList[source];
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void printGraph() {
		for (int i = 0; i < numVertices; i++) {
			System.out.print(buildings[i].getName() + " -> ");
			node current = adjacencyList[i];
			while (current != null) {
				System.out.print(buildings[current.destination].getName() + "(" + current.weight + ") -> ");
				current = current.next;
			}
			System.out.println("null");
		}
	}

	public void dijkstra(int source) {
		int[] dist = new int[numVertices];
		boolean[] sptSet = new boolean[numVertices];

		for (int i = 0; i < numVertices; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[source] = 0;

		for (int count = 0; count < numVertices - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;

			node current = adjacencyList[u];
			while (current != null) {
				int v = current.destination;
				if (!sptSet[v] && dist[u] != Integer.MAX_VALUE && dist[u] + current.weight < dist[v]) {
					dist[v] = dist[u] + current.weight;
				}
				current = current.next;
			}
		}
		System.out.println("Shortest paths from " + buildings[source].getName() + ":");
		for (int i = 0; i < numVertices; i++) {
			System.out.println("To " + buildings[i].getName() + " = " + dist[i]);
		}
	}

	private int minDistance(int[] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int v = 0; v < numVertices; v++) {
			if (!sptSet[v] && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
}
