package it.unibo.generics.graph.impl;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
public class GraphImplDFS<N> extends AbstractGraphImpl<N>{

    private boolean DFSSourceToTarget(List<N> path, Map<N, Boolean> visited, N node, N dest) {
        visited.replace(node, false, true);
        path.add(node);

        if(node.equals(dest)) {
            return true;
        }

        Iterator<N> iter = getEdges().get(node).listIterator();
        while(iter.hasNext()) {
            N n = iter.next();
            if(! visited.get(n)) {
                return DFSSourceToTarget(path, visited,  n, dest);
            }
        }
        return false;
    }


    @Override
    public List<N> getPath(N source, N target) {
        List<N> path = new LinkedList<>();  
        Map<N, Boolean> visited= new HashMap<>();
        Iterator<N> iter = nodeSet().iterator();
        while(iter.hasNext()) {
            visited.put(iter.next(), false);
        }
        
        if(DFSSourceToTarget(path, visited, source, target)) {
            return path;
        } 

        return null;
    }
    
}
