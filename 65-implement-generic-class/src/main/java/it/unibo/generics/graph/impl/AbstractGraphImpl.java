package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Graph;

import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


public abstract class AbstractGraphImpl<N> implements Graph<N>{
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

    public Map<N, LinkedList<N>> getEdges() {
        Map<N, LinkedList<N>> defensiveCopy = new HashMap<>();
        defensiveCopy.putAll(this.edgesMap);
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
}
