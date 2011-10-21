package pipes;

/** A DSL for working with a Pipeline<S, E> where end-type E is concretely specified. */
public interface ConcretePipelineDsl<S, E> extends PipelineDsl<S, E> {
  /** Returns this concrete DSL as a generic DSL. */
  public GenericPipelineDsl<S, E> generic();
}
