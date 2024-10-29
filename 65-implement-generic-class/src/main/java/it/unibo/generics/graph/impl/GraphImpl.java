package it.unibo.generics.graph.impl;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import it.unibo.generics.graph.api.Graph;
public class GraphImpl<N> implements Graph<N>{

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



    
    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }
    
}
