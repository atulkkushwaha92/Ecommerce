
export const MAX_PRODUCTS_PER_PAGE = 16;

export const TAB_CONFIG = [
    {index: 0, label: 'MEN', color: '#ee5f73', mapKey: "men"},
    {index: 1, label: 'WOMEN', color: '#fb56c1', mapKey: "women"}
];

export const INITIAL_PAGINATION_STATE = {
    pageNumber: 1,
    maxProducts: MAX_PRODUCTS_PER_PAGE,
    isLoadedFromURL: true
}

export const INITIAL_SORT_STATE = {
    id: 1,
    value: null,
    isLoadedFromURL: true
}

export const INITIAL_SELECTED_FILTER_ATTRIBUTE_STATE = {
    genders: [],
    apparels: [],
    brands: [],
    prices: [],
    oldQuery: null,
    newQuery: null
}

export const INITIAL_SHIPPING_OPTION_STATE = {
    price: "Free",
    submitted: false
}

export const INITIAL_SHIPPING_ADDRESS_STATE = {
    values: null,
    submitted: false
}

export const FILTER_ATTRIBUTES = ["genders", "apparels", "brands", "prices"]
export const SORT_ATTRIBUTE = "sortby"
export const PAGE_ATTRIBUTE = "page"

export const MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July',
    'August', 'September', 'October', 'November', 'December'];

export const HOME_PAGE_API_OBJECT_LEN = 2;
export const TABS_API_OBJECT_LEN = 2;
