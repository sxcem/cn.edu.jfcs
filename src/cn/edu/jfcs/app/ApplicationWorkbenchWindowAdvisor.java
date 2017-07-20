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
    	//���ô��ڴ�С
    	shell.setSize(1280,750);
    	
    	//���ô����Զ�����
    	Rectangle screenSize= Display.getDefault().getClientArea();
    	Rectangle frameSize= shell.getBounds();
    	shell.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
	}


	public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        //�˴����ô�С��Ч ʹ��postWindowOpen����
        //configurer.setInitialSize(new Point(900, 600));
        //��ʱ����ʾ������
        configurer.setShowCoolBar(false);
        //��ʾ״̬��
        configurer.setShowStatusLine(true);
        //����ֻ��ʾ��С�����رհ�ť
        configurer.setShellStyle(SWT.MIN|SWT.CLOSE);
        //���ô��ڱ���
        configurer.setTitle(IAppConstants.APPLICATION_TITLE);
    }
}
