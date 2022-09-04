package com.nohit.jira_project.controller;

import static com.nohit.jira_project.constant.AttributeConstant.FLAG_MSG_PARAM;
import static com.nohit.jira_project.constant.AttributeConstant.MSG_PARAM;
import static com.nohit.jira_project.constant.TemplateConstant.ABOUT_TEMP;
import static com.nohit.jira_project.constant.ViewConstant.ABOUT_VIEW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nohit.jira_project.model.GioHang;
import com.nohit.jira_project.model.KhachHang;
import com.nohit.jira_project.service.GioHangService;
import com.nohit.jira_project.util.AuthenticationUtil;

@Controller
@RequestMapping(ABOUT_VIEW)
public class GioiThieuController {
	@Autowired
    private GioHangService gioHangService;

    @Autowired
    private AuthenticationUtil authenticationUtil;

    // Fields
    private KhachHang mCurrentAccount;
    private String mMsg;
    private boolean mIsByPass;
    private boolean mIsMsgShow;

    // Load contact
    @GetMapping("")
    public ModelAndView contact() {
        var mav = new ModelAndView(ABOUT_TEMP);
        GioHang gioHang;
        // check current account still valid
        if (!isValidAccount()) {
            gioHang = new GioHang();
        } else {
            var id = mCurrentAccount.getId();
            gioHang = gioHangService.getGioHang(id);
            // check gio_hang exist
            if (gioHang == null) {
                gioHang = new GioHang();
                gioHang.setId(id);
                gioHangService.saveGioHang(gioHang);
            }
        }
        mav.addObject("khachHang", mCurrentAccount);
        mav.addObject("gioHang", gioHang);
        mav.addObject("login", mCurrentAccount != null);
        showMessageBox(mav);
        mIsByPass = false;
        return mav;
    }


    // Check valid account
    private boolean isValidAccount() {
        // check bypass
        if (mIsByPass) {
            return true;
        } else {
            mCurrentAccount = authenticationUtil.getAccount();
            return mCurrentAccount != null;
        }
    }

    // Show message
    private void showMessageBox(ModelAndView mav) {
        // check flag
        if (mIsMsgShow) {
            mav.addObject(FLAG_MSG_PARAM, true);
            mav.addObject(MSG_PARAM, mMsg);
            mIsMsgShow = false;
        }
    }
}