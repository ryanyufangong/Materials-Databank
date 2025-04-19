import React, {useEffect, useState} from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as RiIcons from "react-icons/ri";
import * as IoIcons from "react-icons/io";
import SubMenu from "./SubMenu";
import { IconContext } from "react-icons";
import MaterialTable from "./MaterialTable";
import {type} from "@testing-library/user-event/dist/type"; // Import the table

const Nav = styled.div`
  background: #15171c;
  height: 80px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
`;

const NavIcon = styled(Link)`
  margin-left: 2rem;
  font-size: 2rem;
  height: 80px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
`;

const SidebarNav = styled.nav`
  background: #15171c;
  width: 250px;
  height: 100vh;
  display: flex;
  justify-content: center;
  position: fixed;
  top: 0;
  left: ${({ sidebar }) => (sidebar ? '0' : '-100%')};
  transition: 350ms;
  z-index: 10;
`;

const SidebarWrap = styled.div`
  width: 100%;
`;

const ContentArea = styled.div`
  margin-left: 260px;
  padding: 20px;
  background: #5c5c5c;
  min-height: 100vh;
`;

const MaterialSideBar = () => {
    const [sidebar, setSidebar] = useState(false);
    const [sideBarData, setSideBarData] = useState([]);
    const [activeContent, setActiveContent] = useState(null);

    useEffect(() => {
        const fetchMaterialTypes = async () => {
            try {
                const parentResponse = await fetch('http://localhost:8000/materialType/getRootMaterialTypes', {
                    method: 'post',
                    headers: {'content-type' : 'application/json'},
                    body: JSON.stringify({})
                });
                const parentTypes = await parentResponse.json();

                const materialData = await Promise.all(
                    parentTypes.map(async (parent) => {
                        const childResponse = await fetch('http://localhost:8000/materialType/getChildMaterialTypes', {
                            method: 'post',
                            headers: { 'Content-Type': 'application/json' },
                            body: JSON.stringify({ parent_material_type: parent.materialTypeID })
                        });
                        const childTypes = await childResponse.json();

                        console.log("Fetched children for parent", parent.materialTypeID, childTypes);

                        return {
                            title: parent.name,
                            path: `/materials/${parent.materialTypeID}`,
                            iconClosed: <RiIcons.RiArrowDownSFill />,
                            iconOpened: <RiIcons.RiArrowUpSFill />,
                            subNav: childTypes.map((child) => {
                                return{
                                    title: child.name,
                                    path: `/materials/${parent.materialTypeID}/${child.materialTypeID}`,
                                    materialTypeId: child.materialTypeID,
                                    icon: <IoIcons.IoIosPaper />,
                                };

                            })
                        };
                    })
                );
                setSideBarData(materialData);

                if (materialData.length > 0) {
                    const firstCategoryWithSubNav = materialData.find(category => category.subNav && category.subNav.length > 0);
                    if (firstCategoryWithSubNav) {
                        setActiveContent(firstCategoryWithSubNav.subNav[0]);
                    }
                }
            }
            catch (error) {
                console.error("Error fetching materials: ", error);
            }
        };

        fetchMaterialTypes();
    }, []);

    useEffect(() => {
        if (sideBarData.length > 0 && !activeContent) {
            const firstCategoryWithSubNav = sideBarData.find(category => category.subNav && category.subNav.length > 0);
            if (firstCategoryWithSubNav) {
                setActiveContent(firstCategoryWithSubNav.subNav[0]);
            }
        }
    }, [sideBarData, activeContent]);


    return (
        <>
            <div className="sidebar">
                {sideBarData.map((category, index) => (

                    <div key={index} className="menu-item">
                        <div className="menu-title">
                            {category.title} {category.icon}
                        </div>
                        <div className="submenu">
                            {category.subNav &&
                                category.subNav.map((item, subIndex) => (
                                    <SubMenu key={subIndex} item={item} setActiveContent={setActiveContent} />
                                ))}
                        </div>
                    </div>
                ))}
            </div>
            <ContentArea>
                {activeContent ? (
                    <>
                        <h1>{activeContent.title}</h1>
                        <MaterialTable materialTypeId={activeContent.materialTypeId} />
                    </>
                ) : (
                    <p>Select a category to view materials</p>
                )}
            </ContentArea>
        </>
    );
};

export default MaterialSideBar;
