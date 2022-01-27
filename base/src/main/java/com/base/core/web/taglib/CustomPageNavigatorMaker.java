package com.base.core.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.base.core.web.paging.PageNavigator;


@SuppressWarnings("serial")
public class CustomPageNavigatorMaker extends TagSupport
{
    PageNavigator navigator = null;
    String viewMethod = null;
    String funcName = "";
    int  statusIndex = 0;

	public int doStartTag() throws JspException
    {
        try
        {
            this.pageContext.getOut().write(this.makePageNavigator().toString());
        }
        catch (Exception e)
        {
        	e.printStackTrace(System.err);
        }

        return EVAL_BODY_INCLUDE;
    }

    private String makePageNavigator()
    {
        StringBuffer html = new StringBuffer();
        if(funcName ==null || "".equals(funcName)){
        	this.funcName ="movePage";
        }

        try
        {
            if (viewMethod == null || "Navigator".equalsIgnoreCase(viewMethod))
            {
               // html.append("<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'>");
               //     html.append("<tr>");
               //         html.append("<td align='left' valign='middle'>");

                html.append("<ul class='pagination justify-content-center' id='pageNavigator'>");

                if (this.navigator != null)
                {
                    int previousPageNumber = this.navigator.getPreviousPageNumber();
                    int nextPageNumber = this.navigator.getNextPageNumber();

                    if (previousPageNumber > 0)
                    {

                        html.append("<li onclick='"+this.funcName+"(1);' class='page-item'><a class='page-link' href='#'> << </a></li>");
                        html.append("<li onclick='"+this.funcName+"(" + previousPageNumber + ");' class='page-item'><a class=\"page-link\" href=\"#\"> < </a></li>");
                    }

                    for (int i = this.navigator.getStartPageNumber(); i <= this.navigator.getLastPageNumber(); i++)
                    {
                        if (i == this.navigator.getCurrentPageIndex()) html.append("<li onclick='"+this.funcName+"(" + i + ");' class='page-item active'  ><a class=\"page-link\" href=\"#none;\">" + i +"</a></li>");

                        else html.append("<li onclick='"+this.funcName+"(" + i + ");' class='page-item' > <a class='page-link' href='#none;'>" + i +"</a></li>");
                    }

                    if (nextPageNumber <= this.navigator.getLastPage())
                    {
                        html.append("<li onclick='"+this.funcName+"(" + nextPageNumber + ");' class='page-item'><a class='page-link' href='#'> > </a></li>");
                        if (this.navigator.getCurrentPageIndex() < this.navigator.getLastPage())
                            html.append("<li onclick='"+this.funcName+"(" + this.navigator.getLastPage() + ");' class='page-item'><a class='page-link' href='#'> >> </a></li>");
                    }
                }
                else html.append("<li class='off'>1</li>");


                html.append(" </ul>");
                //        html.append("</td>");
                 //   html.append("</tr>");
               // html.append("</table>");
            }
            else if ("Total".equalsIgnoreCase(viewMethod))
            {
                html.append("<table width='100%' border='0' cellpadding='0' cellspacing='0'>");
                    html.append("<tr>");
                        html.append("<td align='left'>");
                            html.append("<div id='total' style='text-align:right;'>");
                            html.append("<font style='color:#FF5454; font-weight:normal;'>Page : "
                            		+ (this.navigator != null ? (this.navigator.getCurrentPageIndex() + "/" + this.navigator.getLastPage()) : "1/1") +
                                    "&#160&#160;<font style='color:#0012FF; font-weight:normal;'>Total : "
                            		+ (this.navigator != null ? this.navigator.getTotalCount() : 0));
                            html.append("</font></div>");
                        html.append("</td>");
                    html.append("</tr>");
                html.append("</table>");
            }
            else if ("OnlyTotal".equalsIgnoreCase(viewMethod))
            {
                html.append("<table width='100%' border='0' cellpadding='0' cellspacing='0'>");
                    html.append("<tr>");
                        html.append("<td align='left' valign='middle'>");
                            html.append("<div id='total' style='text-align:right;'>");
                            html.append("<font style='color:#0012FF; font-weight:bold;'>Total : " +
                            		(this.navigator != null ? this.navigator.getTotalCount() : 0) + "</font></div>");
                        html.append("</td>");
                    html.append("</tr>");
                html.append("</table>");
            }
            else if ("pageSelect".equalsIgnoreCase(viewMethod))
            {

            	html.append("<li class='fl mt_3'>");
            	html.append("<select id='pageSize'  name='pageSize' class='mr_3' onchange='"+this.funcName+"();' >");
            	html.append("<option value='10' "+( this.navigator != null &&  this.navigator.getPageSize() ==10  ? "selected" : "" )+" >10개</option>");
            	html.append("<option value='30' "+( this.navigator != null &&  this.navigator.getPageSize() ==30  ? "selected" : "" )+" >30개</option>");
            	html.append("<option value='50' "+( this.navigator != null &&  this.navigator.getPageSize() ==50  ? "selected" : "" )+" >50개</option>");
            	html.append("<option value='100' "+( this.navigator != null &&  this.navigator.getPageSize() ==100  ? "selected" : "" )+" >100개</option>");
            	html.append(" </select>   </li>");

            }else  if ("rowSeq".equalsIgnoreCase(viewMethod))//List의 rownum 오름차순으로 ex)3,2,1
            {
            	int rowSeq = 0 ;

            	if(this.navigator.getCurrentPageIndex() == 0){
            		rowSeq = this.navigator.getTotalCount()- statusIndex;
            	}else{
            		rowSeq = this.navigator.getTotalCount() -((this.navigator.getCurrentPageIndex()-1) *  this.navigator.getPageSize() )- statusIndex;
            	}
            	html.append(rowSeq);
            }

        }
        catch (Exception e)
        {
        }

        return html.toString();
    }

    /**
     *
     * @param page
     */
    public void setPageInstance(PageNavigator navigator)
    {
        this.navigator = navigator;
    }

    /**
     *
     * @param viewMethod
     */
    public void setViewMethod(String viewMethod)
    {
        this.viewMethod = viewMethod;
    }

    /**
	 * @param funcName the funcName to set
	 */
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public void setStatusIndex(int statusIndex) {
		this.statusIndex = statusIndex;
	}

}