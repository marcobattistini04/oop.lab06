package it.unibo.generics.graph.impl;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;
public class GraphImpl<N> implements Graph<N>{

    @Override
    public void addNode(N node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNode'");
    }

    @Override
    public void addEdge(N source, N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public Set<N> nodeSet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nodeSet'");
    }

    @Override
    public Set<N> linkedNodes(N node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linkedNodes'");
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }
    
}
