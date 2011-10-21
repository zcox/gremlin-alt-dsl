package pipes;

/** DSLs can just extend this, specifying a constructor that calls super(pipeline). */
public class AbstractPipelineDsl<S, E> implements PipelineDsl<S, E> {
  protected final Pipeline<S, E> pipeline;

  protected AbstractPipelineDsl(Pipeline<S, E> pipeline) {
    this.pipeline = pipeline;
  }

  @Override
  public Pipeline<S, E> pipeline() {
    return pipeline;
  }
}
