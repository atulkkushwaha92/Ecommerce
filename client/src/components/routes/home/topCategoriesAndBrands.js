import React from 'react';
import {Grid} from "@material-ui/core";
import {Link} from "react-router-dom";
import log from 'loglevel';
import {MAX_PRODUCTS_PER_PAGE} from "../../../constants/constants";
import {useSelector} from "react-redux";

const queryType = {
    apparel: 1
}

const TopCategoriesAndBrands = () => {
    const homeAPIData = useSelector(state => state.homePageDataReducer)

    const renderImageList = (imageList, filterQueryType) => {

        return imageList.map(info => {

            let filterQuery = null

            // prepare query parameters
            switch (filterQueryType) {
                case queryType.apparel:
                    if (info.apparelInfo && info.genderInfo) {
                        filterQuery = `apparels=${info.apparelInfo.id}::genders=${info.genderInfo.id}`
                    }
                    break
                default:
                    log.error("[TopCategoriesAndBrands]: filterQueryType is unsupported = " + filterQueryType)
                    return null
            }

            log.trace(`[TopCategoriesAndBrands]: filterQuery = ${filterQuery}, filterQueryType = ${filterQueryType}`)
            return (
                <Grid item xs={6} sm={2} key={info.title} style={{textAlign: "center"}}>
                    <Link to={`/products?q=${filterQuery}::page=0,${MAX_PRODUCTS_PER_PAGE}`}>
                        <img src={info.imageURL} alt={info.imageLocalPath} style={{width: '80%', height: '100%'}}
                             title={info.title}/>
                    </Link>
                </Grid>
            )
        });
    };

    const renderCategoryAndBrandsList = (title, dataList, queryType) => {
        return (
            <>
                <Grid container style={{fontWeight: "bold",
                    fontSize: "2rem", padding: "2rem 0 0 1rem", textDecoration: "underline"}}>
                    {title}
                </Grid>
                <Grid container style={{padding: '2rem 0'}}>
                    {renderImageList(dataList, queryType)}
                </Grid>
            </>
        )
    }

    log.info("[TopCategoriesAndBrands]: Rendering TopCategoriesAndBrands Component")

    return (
        <>
            {renderCategoryAndBrandsList("Categories - 7466fa84-05a9-43fb-a296-aeb4a5107ab9", homeAPIData.data.apparels, queryType.apparel)}
        </>
    )
};
export default TopCategoriesAndBrands;