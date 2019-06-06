package jtool.jfinal;


import com.jfinal.core.Controller;

public abstract class BaseController extends Controller
{
    /**
     * render
     *
     * @param code    code
     * @param objects result
     */
    public void jrender (int code, Object... objects)
    {
        JRender.render(this, code, objects);
    }

    /**
     * 返回成功值 code=0
     *
     * @param objects result
     */
    public void jrenderSuccess (Object... objects)
    {
        JRender.render(this, 0, objects);
    }

    /**
     * 返回失败值 code=1
     *
     * @param objects result
     */
    public void jrenderError (Object... objects)
    {
        JRender.render(this, 1, objects);
    }
}
