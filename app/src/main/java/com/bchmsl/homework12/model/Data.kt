package com.bchmsl.homework12.model

import com.bchmsl.homework12.R

typealias D = R.drawable

object Data {
    val carsList = listOf(
        Model("GLA", 36400, Model.Companion.Category.SUV, D.img_mb_gla),
        Model("GLB", 38600, Model.Companion.Category.SUV, D.img_mb_glb),
        Model("GLC", 43850, Model.Companion.Category.SUV, D.img_mb_glc),
        Model("GLC Coupe", 52500, Model.Companion.Category.SUV, D.img_mb_glc_coupe),
        Model("GLE", 56150, Model.Companion.Category.SUV, D.img_mb_gle),
        Model("GLE Coupe", 78450, Model.Companion.Category.SUV, D.img_mb_gle_coupe),
        Model("GLS", 77850, Model.Companion.Category.SUV, D.img_mb_gls),
        Model("GLS Maybach", 160500, Model.Companion.Category.SUV, D.img_mb_gls_maybach),
        Model("G-Class", 131750, Model.Companion.Category.SUV, D.img_mb_g),
        Model("A-Class", 33950, Model.Companion.Category.SEDAN, D.img_mb_a),
        Model("C-Class", 43550, Model.Companion.Category.SEDAN, D.img_mb_c),
        Model("E-Class", 54950, Model.Companion.Category.SEDAN, D.img_mb_e),
        Model("EQS", 102310, Model.Companion.Category.SEDAN, D.img_mb_eqs_sedan),
        Model("S-Class", 111100, Model.Companion.Category.SEDAN, D.img_mb_s),
        Model("S-Class Maybach", 184900, Model.Companion.Category.SEDAN, D.img_mb_s_maybach),
        Model("E-Class", 68400, Model.Companion.Category.WAGON, D.img_mb_e_wagon),
        Model("CLA", 38200, Model.Companion.Category.COUPE, D.img_mb_cla),
        Model("C-Class", 47850, Model.Companion.Category.COUPE, D.img_mb_c_coupe),
        Model("E-Class", 66100, Model.Companion.Category.COUPE, D.img_mb_e_coupe),
        Model("CLS", 72950, Model.Companion.Category.COUPE, D.img_mb_cls_coupe),
        Model("AMG GT 4-door", 92500, Model.Companion.Category.COUPE, D.img_mb_amg_gt_4door),
        Model("AMG GT", 118600, Model.Companion.Category.COUPE, D.img_mb_amg_gt),
        Model("C-Class", 55400, Model.Companion.Category.CONVERTIBLE, D.img_mb_c_cabrio),
        Model("E-Class", 73250, Model.Companion.Category.CONVERTIBLE, D.img_mb_e_cabrio),
        Model("AMG GT", 130700, Model.Companion.Category.CONVERTIBLE, D.img_mb_amg_gt_cabrio),
        Model("SL", null, Model.Companion.Category.ROADSTER, D.img_mb_sl_roadster),
        Model("EQS", 102310, Model.Companion.Category.ELECTRIC, D.img_mb_eqs)
    )

    var selectedModelsList = listOf<Model>()
}