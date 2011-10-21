package pipes;

/** A DSL for working with a Pipeline<S, E>. */
public interface PipelineDsl<S, E> {
  /** Returns this DSL's underlying pipeline. */
  public Pipeline<S, E> pipeline();
}
