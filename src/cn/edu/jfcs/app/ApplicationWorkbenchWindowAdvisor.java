package cn.edu.jfcs.app;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import cn.edu.jfcs.sys.IAppConstants;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    @Override
	public void postWindowOpen() {
		// TODO Auto-generated method stub

    	super.postWindowOpen();
    	Shell shell=getWindowConfigurer().getWindow().getShell();
    	//设置窗口大小
    	shell.setSize(1280,750);
    	
    	//设置窗口自动居中
    	Rectangle screenSize= Display.getDefault().getClientArea();
    	Rectangle frameSize= shell.getBounds();
    	shell.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
	}


	public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        //此处设置大小无效 使用postWindowOpen函数
        //configurer.setInitialSize(new Point(900, 600));
        //暂时不显示工具栏
        configurer.setShowCoolBar(false);
        //显示状态栏
        configurer.setShowStatusLine(true);
        //窗口只显示最小化、关闭按钮
        configurer.setShellStyle(SWT.MIN|SWT.CLOSE);
        //设置窗口标题
        configurer.setTitle(IAppConstants.APPLICATION_TITLE);
    }
}
