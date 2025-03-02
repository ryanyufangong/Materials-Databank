import React from "react";
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';
import * as RiIcons from 'react-icons/ri';

export const MaterialSideBarData = [
    {
        title: 'Resistance Heating Alloys',
        path: '/materials/resistance_heating',
        icon: <AiIcons.AiFillHome />,
        iconClosed: <RiIcons.RiArrowDownSFill />,
        iconOpened: <RiIcons.RiArrowUpSFill />,
        subNav: [
            {
                title: 'Nichrome Alloys',
                path: '/materials/resistance_heating/nichrome',
                materialTypeID: 1,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'FeCrAl Alloys',
                path: '/materials/resistance_heating/fecral',
                materialTypeID: 2,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'Copper Nickel Alloys',
                path: '/materials/resistance_heating/copper_nickel',
                materialTypeID: 3,
                icon: <IoIcons.IoIosPaper />,
            },
        ]
    },
    {
        title: 'Superalloys',
        path: '/materials/superalloys',
        icon: <AiIcons.AiFillHome />,
        iconClosed: <RiIcons.RiArrowDownSFill />,
        iconOpened: <RiIcons.RiArrowUpSFill />,
        subNav: [
            {
                title: 'High Temperature Alloys',
                path: '/materials/superalloys/high_temperature',
                materialTypeID: 4,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'Corrosion Resistant Alloys',
                path: '/materials/superalloys/corrosion_resistant',
                materialTypeID: 5,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'Cast Superalloys',
                path: '/materials/superalloys/cast',
                materialTypeID: 6,
                icon: <IoIcons.IoIosPaper />,
            },
        ]
    },
    {
        title: 'Precision Alloys',
        path: '/materials/precision_alloys',
        icon: <AiIcons.AiFillHome />,
        iconClosed: <RiIcons.RiArrowDownSFill />,
        iconOpened: <RiIcons.RiArrowUpSFill />,
        subNav: [
            {
                title: 'Soft Magnetic Alloys',
                path: '/materials/precision_alloys/soft_magnetic',
                materialTypeID: 7,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'Permanent Magnetic Alloys',
                path: '/materials/precision_alloys/permanent_magnetic',
                materialTypeID: 8,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'Elastic Alloys',
                path: '/materials/precision_alloys/elastic',
                materialTypeID: 9,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'Expansion Alloys',
                path: '/materials/precision_alloys/expansion',
                materialTypeID: 10,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'Thermostatic Bimetals',
                path: '/materials/precision_alloys/thermostatic_bimetals',
                materialTypeID: 11,
                icon: <IoIcons.IoIosPaper />,
            },
            {
                title: 'Precision Resistance Alloys',
                path: '/materials/precision_alloys/precision_resistance',
                materialTypeID: 12,
                icon: <IoIcons.IoIosPaper />,
            },
        ]
    },
];
