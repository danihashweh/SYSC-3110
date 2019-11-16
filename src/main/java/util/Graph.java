package util;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * This class models a graph in the Rabbits and Foxes game.
 * 
 * @author Samuel Gamelin
 * @author Mohamed Radwan
 * 
 * @version 3.0
 */
public class Graph {
	/**
	 * Performs a breadth-first search on the specified node.
	 * 
	 * @param root The node from which to stem the search
	 * @return The list of nodes that form the winning path. Should there be no
	 *         winning path, this list will be empty.
	 */
	public List<Node> breadthFirstSearch(Node root) {
		if (root.isWinningNode()) {
			return new LinkedList<>();
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		Set<Node> visited = new HashSet<>();
		Map<Node, Node> parentMap = new HashMap<>();
		List<Node> winningPathList = new LinkedList<>();

		while (!queue.isEmpty()) {
			Node currentNode = queue.remove();
			if (!visited.contains(currentNode)) {
				visited.add(currentNode);
				Set<Node> children = currentNode.getChildren();
				children.removeAll(visited);
				for (Node child : children) {
					parentMap.put(child, currentNode);
					if (child.isWinningNode()) {
						Node node = child;
						while (node != null) {
							winningPathList.add(0, node);
							node = parentMap.get(node);
						}
						return winningPathList;
					} else {
						queue.add(child);
					}
				}
			}
		}
		return winningPathList;
	}
}
