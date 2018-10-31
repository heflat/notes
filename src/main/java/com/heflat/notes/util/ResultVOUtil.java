package com.heflat.notes.util;

import com.heflat.notes.enums.NotesEnum;
import com.heflat.notes.vo.ResultVO;

/**
 * Json 返回视图工具类
 *
 * @author heflat
 * @date 2018-10-23 11:20
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(NotesEnum.SUCCESS.getCode());
        resultVO.setMessage(NotesEnum.SUCCESS.getMessage());
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(NotesEnum notesEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(notesEnum.getCode());
        resultVO.setMessage(notesEnum.getMessage());
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO error(NotesEnum notesEnum, Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(notesEnum.getCode());
        resultVO.setMessage(notesEnum.getMessage());
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO error() {
        return error(NotesEnum.ERROR);
    }
}