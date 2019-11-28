package jtool.entity;

public class JRuntimeException extends RuntimeException
{
    private static final long serialVersionUID = -5365630128856068164L;

    public JRuntimeException ()
    {
    }

    public JRuntimeException (String var1)
    {
        super(var1);
    }

    public JRuntimeException (String var1, Throwable var2)
    {
        super(var1, var2);
    }

    public JRuntimeException (Throwable var1)
    {
        super(var1);
    }
}
