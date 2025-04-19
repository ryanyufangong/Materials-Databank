import React, { useState } from "react";
import styled from "styled-components";

const SidebarLink = styled.div`
  display: flex;
  color: #e1e9fc;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  list-style: none;
  height: 60px;
  text-decoration: none;
  font-size: 18px;
  cursor: pointer;

  &:hover {
    background: #252831;
    border-left: 4px solid #632ce4;
  }
`;

const SidebarLabel = styled.span`
  margin-left: 16px;
`;

const DropdownLink = styled.div`
  background: #414757;
  height: 60px;
  padding-left: 3rem;
  display: flex;
  align-items: center;
  color: rgba(245, 245, 245, 0.96);
  font-size: 18px;
  cursor: pointer;

  &:hover {
    background: #632ce4;
  }
`;

const SubMenu = ({ item, setActiveContent }) => {
    const [subnav, setSubnav] = useState(false);

    const showSubnav = () => {
        if (item.subNav) {
            setSubnav(!subnav);
        }
    };

    const handleClick = (title, materialTypeId) => {
        console.log("Clicked on:", title, "MaterialTypeID:", materialTypeId);
        setActiveContent({ title, materialTypeId });
    };


    return (
        <>
            <SidebarLink
                onClick={() => {
                    showSubnav();
                    if (!item.subNav) {
                        handleClick(item.title, item.materialTypeId);
                        //setActiveContent(item.materialTypeId);
                    }
                }}
            >
                <div>
                    {item.icon}
                    <SidebarLabel>{item.title}</SidebarLabel>
                </div>
                <div>
                    {item.subNav && subnav ? item.iconOpened : item.subNav ? item.iconClosed : null}
                </div>
            </SidebarLink>
            {subnav &&
                item.subNav.map((subItem, index) => (
                    <DropdownLink key={index} onClick={() => handleClick(subItem.title, subItem.materialTypeId)}>
                        {subItem.icon}
                        <SidebarLabel>{subItem.title}</SidebarLabel>
                    </DropdownLink>
                ))}
        </>
    );
};


export default SubMenu;
