package it.unibo.generics.graph.impl;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import it.unibo.generics.graph.api.Graph;
public class GraphImplDFS<N> implements Graph<N>{

    public GraphImplDFS(){
    }
    private Set<N> nodes = new HashSet<>();
    private Map<N, LinkedList<N>> edgesMap = new HashMap<>();
    @Override
    public void addNode(N node) {
        if(! this.nodes.contains(node) && node != null) {
            this.nodes.add(node);
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if(! (source == null || target == null )) {
            if( ! this.edgesMap.containsKey(source)) {
                this.edgesMap.put(source, new LinkedList<N>());
                this.edgesMap.get(source).add(target);
            }else {
                this.edgesMap.get(source).add(target);
            }
        }
    }

    @Override
    public Set<N> nodeSet() {
        Set<N> defensiveCopy = new HashSet<>();
        defensiveCopy.addAll(this.nodes);
        return defensiveCopy;
    }

    @Override
    public Set<N> linkedNodes(N node) {
        if( this.edgesMap.containsKey(node)) {
            Set <N> defensiveCopy = new HashSet<> ();
            defensiveCopy.addAll(this.edgesMap.get(node));
            return defensiveCopy;
        }
        System.out.println(" the graph implemented doesn't have any edges with " + node + " as source");
        return null;
    }



    private boolean DFSSourceToTarget(List<N> path, Map<N, Boolean> visited, N node, N dest) {
        visited.replace(node, false, true);
        path.add(node);

        if(node.equals(dest)) {
            return true;
        }

        Iterator<N> iter = this.edgesMap.get(node).listIterator();
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
        Iterator<N> iter = this.nodes.iterator();
        while(iter.hasNext()) {
            visited.put(iter.next(), false);
        }
        
        if(DFSSourceToTarget(path, visited, source, target)) {
            return path;
        } 

        return null;
    }
    
}
