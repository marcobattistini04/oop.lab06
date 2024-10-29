package it.unibo.generics.graph.impl;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphImplBFS<U> extends AbstractGraphImpl<U>{

    private List<U> BFSSourceToTarget(Map<U, LinkedList<U>> edges, U node, U target) {
        List<U> nodesQueue = new LinkedList<>();       //traversing node queue
        Map<U, ArrayList<U>> paths = new HashMap<>();  // maps tracking all the paths between nodes

        nodesQueue.addLast(node);
        ArrayList <U> init = new ArrayList<>();
        init.add(node);
        paths.put(node, init);

        while(! nodesQueue.isEmpty()) {
            U current = nodesQueue.removeFirst();

            if( current.equals(target)) {
                return paths.get(current);
            }

            for(U adiacentNode : linkedNodes(current)) {
                if(! paths.containsKey(adiacentNode)) {
                     nodesQueue.addLast(adiacentNode);
                    ArrayList<U> path = new ArrayList<>(paths.get(current));
                    path.add(adiacentNode);
                    paths.put(adiacentNode, path);
                }
            }
        }

        return null;
    }
    @Override
    public List<U> getPath(U source, U target) {
        Map<U, LinkedList<U>> edges = getEdges(); 
        return BFSSourceToTarget(edges, source, target);
    }
    
}
