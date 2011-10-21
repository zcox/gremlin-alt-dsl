package gremlin;

import java.util.Arrays;
import java.util.Collection;

import pipes.DuplicateFilterPipe;
import pipes.GenericPipelineDsl;
import pipes.Pipeline;
import pipes.RetainFilterPipe;
import blueprints.Edge;
import blueprints.Vertex;

public class DslTest {
  public static void test() {
    // just some things we'll use below
    Vertex v = null;
    Collection<Vertex> vertices = Arrays.asList(new Vertex());

    // we're trying to accomplish this (maybe it's a non-sensical pipeline, but is sufficiently complex & realistic for this test):
    // g.v(1).outE.inV.dedup.retain(vertices).outE.inV

    // manually calling static factory methods (yuck)
    Pipeline<Vertex, Vertex> p0 = new Pipeline<Vertex, Vertex>();
    Pipeline<Vertex, Edge> p1 = OutEdgesPipe.addTo(p0);
    Pipeline<Vertex, Vertex> p2 = InVertexPipe.addTo(p1);
    Pipeline<Vertex, Vertex> p3 = DuplicateFilterPipe.addTo(p2);
    Pipeline<Vertex, Vertex> p4 = RetainFilterPipe.addTo(p3, vertices);
    Pipeline<Vertex, Edge> p5 = OutEdgesPipe.addTo(p4);
    Pipeline<Vertex, Vertex> p6 = InVertexPipe.addTo(p5);

    // using the DSLs is much nicer
    // still have to use generic() to do VertexPipelineDsl => GenericPipelineDsl, and VertexPipelineDsl.from() to do GenericPipelineDsl =>
    // VertexPipelineDsl (kinda yuck?)
    GenericPipelineDsl<Vertex, Vertex> g1 = VertexPipelineDsl.from(v).outE().inV().generic().dedup().retain(vertices);
    Pipeline<Vertex, Vertex> p7 = VertexPipelineDsl.from(g1).outE().inV().pipeline();

    // same as the above but all squished into a one-liner (wee bit yucky?)
    Pipeline<Vertex, Vertex> p8 = VertexPipelineDsl.from(VertexPipelineDsl.from(v).outE().inV().generic().dedup().retain(vertices)).outE().inV()
        .pipeline();

    // just to eliminate stupid Eclipse warnings...
    System.out.println(p6);
    System.out.println(p7);
    System.out.println(p8);
  }
}
