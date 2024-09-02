import React from "react";
import * as FaIcons from 'react-icons/fa'
import * as AiIcons from 'react-icons/ai'
import * as IoIcons from 'react-icons/io'
import * as RiIcons from 'react-icons/ri'

export const MaterialSideBarData = [
    {
        title: 'Resistance Heating Alloys',
        path: '/Resistance_Heating_Alloys',
        icon: <AiIcons.AiFillHome/>,
        iconClosed: <RiIcons.RiArrowDownSFill/>,
        iconOpened: <RiIcons.RiArrowUpSFill/>,
        subNav: [
            {
                title: 'Nichrome Alloys',
                path: '/Resistance_Heating_Alloys/Nichrome_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'FeCrAl Alloys',
                path: '/Resistance_Heating_Alloys/FeCrAl_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'Copper Nickel Alloys',
                path: '/Resistance_Heating_Alloys/Copper_Nickel_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
        ]
    },
    {
        title: 'Superalloys',
        path: '/Superalloys',
        icon: <AiIcons.AiFillHome/>,
        iconClosed: <RiIcons.RiArrowDownSFill/>,
        iconOpened: <RiIcons.RiArrowUpSFill/>,
        subNav: [
            {
                title: 'High Temperature Alloys',
                path: '/Superalloys/High_Temperature_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'Corrosion Resistant Alloys',
                path: '/Superalloys/Corrosion_Resistant_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'Cast Superalloys',
                path: '/Superalloys/Cast_Superalloys',
                icon: <IoIcons.IoIosPaper/>,
            },
        ]
    },
    {
        title: 'Precision Alloys',
        path: '/Precision_Alloys',
        icon: <AiIcons.AiFillHome/>,
        iconClosed: <RiIcons.RiArrowDownSFill/>,
        iconOpened: <RiIcons.RiArrowUpSFill/>,
        subNav: [
            {
                title: 'Soft Magnetic Alloys',
                path: '/Precision_Alloys/Soft_Magnetic',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'Permanent Magnetic Alloys',
                path: '/Precision_Alloys/Permanent_Magnetic_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'Elastic Alloys',
                path: '/Precision_Alloys/Elastic_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'Expansion Alloys',
                path: '/Precision_Alloys/Expansion_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'Thermostatic Bimetals',
                path: '/Precision_Alloys/Thermostatic_Bimetals',
                icon: <IoIcons.IoIosPaper/>,
            },
            {
                title: 'Precision Resistance Alloys',
                path: '/Precision_Alloys/Precision_Resistance_Alloys',
                icon: <IoIcons.IoIosPaper/>,
            },
        ]
    },
]

