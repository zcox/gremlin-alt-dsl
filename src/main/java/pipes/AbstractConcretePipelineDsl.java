package pipes;

/** Concrete DSLs can just extend this, specifying a concrete end-type and a constructor that calls super(pipeline). */
public abstract class AbstractConcretePipelineDsl<S, E> extends AbstractPipelineDsl<S, E> implements ConcretePipelineDsl<S, E> {

  protected AbstractConcretePipelineDsl(Pipeline<S, E> pipeline) {
    super(pipeline);
  }

  @Override
  public GenericPipelineDsl<S, E> generic() {
    return new GenericPipelineDsl<S, E>(pipeline);
  }
}
